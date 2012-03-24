package hu.advancedweb.lms.evaluation;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.common.collect.Maps;

public class ExamAnswers {
	public Map<String, Map<String, String>>	answers	= Maps.newHashMap();

	@SuppressWarnings("unchecked")
	public ExamAnswers(String providedAnswers) {
		answers = (JSONObject) JSONValue.parse(providedAnswers);
	}

}
