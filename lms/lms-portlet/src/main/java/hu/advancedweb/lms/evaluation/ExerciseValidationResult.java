package hu.advancedweb.lms.evaluation;

import org.mozilla.javascript.ScriptableObject;

public class ExerciseValidationResult extends ScriptableObject {

	public String	text;

	public int		score;

	@Override
	public String getClassName() {
		return getClass().getSimpleName();
	}
}