package hu.advancedweb.lms.evaluation;

import hu.advancedweb.pilot.rhino.ValidationBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;

import org.javatuples.Pair;
import org.json.simple.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ExamEvaluator {

	public static void main(String[] args) {
		ExamValidationResult result = new ExamEvaluator().evaluate(appendAnswers("", "page1", ImmutableMap.of("exc1", "corr1", "exc2", "corr2")), generateDefaultEvaluatorJavascript(new DefaultExamEvaluatorLogic() {
			{
				addCorrectAnswer("page1", "exc1", "corr1", 1);
				addCorrectAnswer("page1", "exc2", "corr2", 2);
			}
		}));
		System.out.println(result);
	}

	public static String appendAnswers(String oldAnswers, String pageName, Map<String, String> newAnswers) {
		if (oldAnswers == null || oldAnswers.trim().compareTo("") == 0) {
			oldAnswers = "{}";
		}
		ExamAnswers ans = new ExamAnswers(oldAnswers);
		ans.answers.put(pageName, Maps.newHashMap(newAnswers));
		return JSONObject.toJSONString(ans.answers);
	}

	public static String generateDefaultEvaluatorJavascript(DefaultExamEvaluatorLogic logic) {
		StringBuilder result = new StringBuilder();

		result.append("function validate(){");
		for (Entry<String, Map<String, Pair<String, Integer>>> pages : logic.correctAnswers.entrySet()) {
			for (Entry<String, Pair<String, Integer>> exercises : pages.getValue().entrySet()) {
				result.append("defaultEvaluatorLogic.addCorrectAnswer('" + pages.getKey() + "', '" + exercises.getKey() + "', '" + exercises.getValue().getValue0() + "', " + exercises.getValue().getValue1() + ");");
			}
		}

		result.append("defaultEvaluator.evaluate(examAnswers,defaultEvaluatorLogic,validationDataObj);}");

		return result.toString();
	}

	public ExamValidationResult evaluate(String answers, String evaluationLogic) {
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
			Scriptable examData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new ExamAnswers(answers), ExamAnswers.class);
			scope.put("examAnswers", scope, examData);

			/*
			 * Loads the validations js function to the scope.
			 */
			Script validationScript = Context.getCurrentContext().compileString(evaluationLogic, "Validation Script", 1, null);
			validationScript.exec(cx, scope);

			/* Loads the default evaluator */
			Scriptable defaultEvaluator = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new DefaultExamEvaluator(), DefaultExamEvaluator.class);
			scope.put("defaultEvaluator", scope, defaultEvaluator);

			Scriptable defaultEvaluatorLogic = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new DefaultExamEvaluatorLogic(), DefaultExamEvaluatorLogic.class);
			scope.put("defaultEvaluatorLogic", scope, defaultEvaluatorLogic);

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

			return validationBean;

			/*
			 * Do something with the filled validation bean.
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Context.exit();
		}

		return null;
	}

	/**
	 * Returns the helper JS functions. (dummy)
	 * 
	 * I think it should contain basic framework functions, to validate all the pages, and DSL like accessor functions to the result object for common validation tasks eg.: -
	 * check(1, questionOne, {'answerOne':1,'answerTwo':0.5}, 'rightAnswer') to validate input 'questionOne' on page 1, or something
	 * 
	 * functions for debugging (something, that adds an entry to the result, and be displayed somewhere)
	 */
	private String getJavascriptFramework() {
		BufferedReader input = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/evaluatorframework.js")));
		StringBuilder contents = new StringBuilder();
		try {
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return contents.toString();
	}

}
