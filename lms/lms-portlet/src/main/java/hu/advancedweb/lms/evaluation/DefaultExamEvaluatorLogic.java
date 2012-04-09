package hu.advancedweb.lms.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.javatuples.Pair;

import com.google.common.collect.Maps;

public class DefaultExamEvaluatorLogic {

	public Map<String, Map<String, Pair<String, Integer>>>	correctAnswers	= Maps.newHashMap();

	public void addCorrectAnswer(String page, String question, String correctAnswer, int score) {
		if (correctAnswers.containsKey(page) == false) {
			correctAnswers.put(page, new HashMap<String, Pair<String, Integer>>());
		}
		correctAnswers.get(page).put(question, Pair.with(correctAnswer, score));
	}

}
