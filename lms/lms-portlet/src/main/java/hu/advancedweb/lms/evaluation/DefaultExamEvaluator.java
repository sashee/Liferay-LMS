package hu.advancedweb.lms.evaluation;

import java.util.Map;
import java.util.Map.Entry;

public class DefaultExamEvaluator {
	public void evaluate(ExamAnswers answers, DefaultExamEvaluatorLogic logic, ExamValidationResult result) {
		int finalScore = 0;
		for (Entry<String, Map<String, String>> pages : answers.answers.entrySet()) {
			String pageName = pages.getKey();
			int pageScore = 0;
			for (Entry<String, String> exercises : pages.getValue().entrySet()) {
				String exerciseName = exercises.getKey();
				if (logic.correctAnswers.get(pages.getKey()).get(exercises.getKey()).getValue0().compareTo(exercises.getValue()) == 0) {
					int exerciseScore = logic.correctAnswers.get(pageName).get(exerciseName).getValue1();
					result.addExerciseResult(pageName, exerciseName, "OK", exerciseScore);
					pageScore += exerciseScore;
				} else {
					result.addExerciseResult(pageName, exerciseName, logic.correctAnswers.get(pageName).get(exerciseName).getValue0(), 0);
				}
			}
			result.setPageScore(pageName, pageScore);
			finalScore += pageScore;
		}
		result.score = finalScore;
	}

}
