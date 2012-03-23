package hu.advancedweb.lms.evaluation;

import java.util.Map;

import org.mozilla.javascript.ScriptableObject;

import com.google.common.collect.Maps;

public class PageValidationResult extends ScriptableObject {

	public int										score;

	public Map<String, ExerciseValidationResult>	exerciseValidations	= Maps.newHashMap();

	@Override
	public String getClassName() {
		return getClass().getSimpleName();
	}

}
