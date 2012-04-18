package hu.advancedweb.lms.evaluation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javatuples.Pair;
import org.json.simple.JSONValue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public class DefaultExamEvaluatorLogic {

	public Map<String, Map<String, Pair<String, Integer>>>	correctAnswers	= Maps.newHashMap();

	public void addCorrectAnswer(String page, String question, String correctAnswer, int score) {
		if (correctAnswers.containsKey(page) == false) {
			correctAnswers.put(page, new HashMap<String, Pair<String, Integer>>());
		}
		correctAnswers.get(page).put(question, Pair.with(correctAnswer, score));
	}

	public String toJson() {
		Map<String, Map<String, List<Object>>> r = Maps.newHashMap();
		for (Entry<String, Map<String, Pair<String, Integer>>> e1 : correctAnswers.entrySet()) {
			r.put(e1.getKey(), new HashMap<String, List<Object>>());
			for (Entry<String, Pair<String, Integer>> e2 : e1.getValue().entrySet()) {
				r.get(e1.getKey()).put(e2.getKey(), ImmutableList.of((Object) e2.getValue().getValue0(), e2.getValue().getValue1()));
			}
		}
		return JSONValue.toJSONString(r);
	}

	@SuppressWarnings("unchecked")
	public static DefaultExamEvaluatorLogic fromJson(String json) {
		DefaultExamEvaluatorLogic result = new DefaultExamEvaluatorLogic();

		Map<String, Map<String, List<Object>>> r = (Map<String, Map<String, List<Object>>>) JSONValue.parse(json);

		for (Entry<String, Map<String, List<Object>>> e1 : r.entrySet()) {
			for (Entry<String, List<Object>> e2 : e1.getValue().entrySet()) {
				result.addCorrectAnswer(e1.getKey(), e2.getKey(), (String) e2.getValue().get(0), Integer.parseInt(e2.getValue().get(1) + ""));
			}
		}
		return result;
	}

}
