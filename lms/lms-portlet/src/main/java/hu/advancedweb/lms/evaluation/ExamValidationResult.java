package hu.advancedweb.lms.evaluation;

import java.util.Map;

import com.google.common.collect.Maps;

public class ExamValidationResult {

	public int									score;

	public Map<String, PageValidationResult>	pageValidations	= Maps.newHashMap();
	
	public void addExerciseResult(String page, String exercise, String text, int score) {
		if (pageValidations.containsKey(page) == false) {
			pageValidations.put(page, new PageValidationResult());
		}
		if (pageValidations.get(page).exerciseValidations.containsKey(exercise) == false) {
			pageValidations.get(page).exerciseValidations.put(exercise, new ExerciseValidationResult());
		}
		pageValidations.get(page).exerciseValidations.get(exercise).text = text;
		pageValidations.get(page).exerciseValidations.get(exercise).score = score;
	}

	public void setPageScore(String page, int score) {
		if (pageValidations.containsKey(page) == false) {
			pageValidations.put(page, new PageValidationResult());
		}
		pageValidations.get(page).score = score;
	}

	public void setExamScore(int score) {
		this.score = score;
	}
	
	public class PageValidationResult {

		public int										score;

		public Map<String, ExerciseValidationResult>	exerciseValidations	= Maps.newHashMap();

		@Override
		public String toString() {
			return "PageValidationResult [score=" + score + ", exerciseValidations=" + exerciseValidations + "]";
		}

	}
	
	public class ExerciseValidationResult {

		public String	text;

		public int		score;

		@Override
		public String toString() {
			return "ExerciseValidationResult [text=" + text + ", score=" + score + "]";
		}
	}

	@Override
	public String toString() {
		return "ExamValidationResult [score=" + score + ", pageValidations=" + pageValidations + "]";
	}


}
