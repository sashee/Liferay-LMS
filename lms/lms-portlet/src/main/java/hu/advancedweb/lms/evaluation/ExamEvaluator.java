package hu.advancedweb.lms.evaluation;

import hu.advancedweb.pilot.rhino.ExamDataBean;
import hu.advancedweb.pilot.rhino.ValidationBean;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class ExamEvaluator {

	public static void main(String[] args) {
		evaluate("abc", "eee");
	}

	public static void evaluate(String answers, String evaluationLogic) {
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
			Scriptable examData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, answers, ExamDataBean.class);
			scope.put("examDataObj", scope, examData);

			/*
			 * Loads the validations js function to the scope.
			 */
			Script validationScript = Context.getCurrentContext().compileString(getValidationJavascript(), "Validation Script", 1, null);
			validationScript.exec(cx, scope);

			/*
			 * Loads the validation data object to the scope.
			 */

			ExamValidationResult validationBean = new ExamValidationResult();
			Scriptable validationData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, validationBean, ValidationBean.class);
			scope.put("validationDataObj", scope, validationData);

			/*
			 * Validate.
			 */
			cx.evaluateString(scope, "validate();", "Main Script", 1, null);

			/*
			 * Do something with the filled validation bean.
			 */
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
	 * I think it should contain basic framework functions, to validate all the pages, and DSL like accessor functions to the result object for common validation tasks eg.: -
	 * check(1, questionOne, {'answerOne':1,'answerTwo':0.5}, 'rightAnswer') to validate input 'questionOne' on page 1, or something
	 * 
	 * functions for debugging (something, that adds an entry to the result, and be displayed somewhere)
	 */
	private static String getJavascriptFramework() {
		return "function validate(){" + "   var validationFunctionBase = 'validatePage';" + "   var pageNum = 1;" + "   while (this[validationFunctionBase + pageNum]){" + "      this[validationFunctionBase + pageNum].call();" + "      pageNum = pageNum + 1;" + "   }" + "};";
	}

	/**
	 * Returns the validation JS function. (dummy)
	 * 
	 * I think it should contain user given validation functions for all the exam pages.
	 */
	private static String getValidationJavascript() {
		return "function validatePage1() {" + "   if (examDataObj == 'abc') validationDataObj.add(1,'questionOne', 1, '');" + // validationDataObj accesses should be
																																			// wrapped by helper functions
		"   else validationDataObj.add(1,'questionOne', 0, 'a helyes valasz 42');" + "};";
	}

}
