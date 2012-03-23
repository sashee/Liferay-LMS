package hu.advancedweb.lms.evaluation;

import java.util.Map;

import org.mozilla.javascript.ScriptableObject;

import com.google.common.collect.Maps;

public class ExamValidationResult extends ScriptableObject {

	public int									score;

	public Map<String, PageValidationResult>	pageValidations	= Maps.newHashMap();

	@Override
	public String getClassName() {
		return getClass().getSimpleName();
	}

}
