package hu.advancedweb.pilot.rhino;


import hu.advancedweb.pilot.rhino.ValidationBean.ValidationObject;

import java.util.Map;

import org.mozilla.javascript.*;

/**
 * Pilot class for scripted validation.
 * @author Dodi
 */
public class RhinoTestMain {
	public static void main(String[] args) {
		new RhinoTestMain().rhinoTest();
	}
	
	public void rhinoTest() {
		Context cx = Context.enter();

		try {
			Scriptable scope = cx.initStandardObjects();
			
			/*
			 * Loads the helper js functions to the scope.
			 */
			Script javascriptFrameworkScript = Context.getCurrentContext().compileString(getJavascriptFramework(), "Framework Script", 1, null);
			javascriptFrameworkScript.exec(cx, scope);
			
			/*
			 * Loads the exam data object to the scope.
			 */
			Scriptable examData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, getExamData(), ExamDataBean.class);
			scope.put("examDataObj", scope, examData);
			
			/*
			 * Loads the validations js function to the scope.
			 */
			Script validationScript = Context.getCurrentContext().compileString(getValidationJavascript(), "Validation Script", 1, null);
			validationScript.exec(cx, scope);
			
			/*
			 * Loads the validation data object to the scope.
			 */
			
			ValidationBean validationBean = new ValidationBean();
			Scriptable validationData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, validationBean, ValidationBean.class);
			scope.put("validationDataObj", scope, validationData);
			
			/*
			 * Validate.
			 */
			cx.evaluateString(scope, "validate();", "Main Script", 1, null);
			
			/*
			 * Do something with the filled validation bean.
			 */
			System.out.println("Result: ");
			Map<String, ValidationObject> validationResultPageOne = validationBean.getTestData().get(1);
			for (Map.Entry<String,ValidationBean.ValidationObject> validationEntry : validationResultPageOne.entrySet()) {
				System.out.println(validationEntry.getKey() + ": score = " + validationEntry.getValue().getScore() + " (" + validationEntry.getValue().getCorrectAnswer() + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Context.exit();
		}
		
		System.out.println(" --- finished --- ");
	}
	
	/**
	 * Returns the helper JS functions. (dummy)
	 * 
	 * I think it should contain basic framework functions, to validate all the pages,
	 * and DSL like accessor functions to the result object for common validation tasks
	 * 	eg.: - check(1, questionOne, {'answerOne':1,'answerTwo':0.5}, 'rightAnswer') to validate input 'questionOne' on page 1, or something
	 * 
	 * functions for debugging (something, that adds an entry to the result, and be displayed somewhere)
	 */
	private String getJavascriptFramework() {
		return
				"function validate(){" +
				"   var validationFunctionBase = 'validatePage';" +
				"   var pageNum = 1;" +
				"   while (this[validationFunctionBase + pageNum]){" +
				"      this[validationFunctionBase + pageNum].call();" +
				"      pageNum = pageNum + 1;" +
				"   }" +
				"};";
	}
	
	/**
	 * Returns the validation JS function. (dummy)
	 * 
	 * I think it should contain user given validation functions for all the exam pages.
	 */
	private String getValidationJavascript() {
		return
				"function validatePage1() {" +
				"   if (examDataObj.testData == 'valami') validationDataObj.add(1,'questionOne', 1, '');" +	// validationDataObj accesses should be wrapped by helper functions
				"   else validationDataObj.add(1,'questionOne', 0, 'a helyes valasz 42');" +
				"};";
	}
	
	/**
	 * Returns the Exam data to be validated. (dummy)
	 * 
	 * Comes from the UI, or DB.
	 */
	private ExamDataBean getExamData() {
		ExamDataBean testDataBean = new ExamDataBean();
		testDataBean.setTestData("valami");
		return testDataBean;
	}
}