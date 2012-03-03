package hu.advancedweb.pilot.rhino;

import java.util.HashMap;
import java.util.Map;

import org.mozilla.javascript.ScriptableObject;

public class ValidationBean extends ScriptableObject {
	
	private static final long serialVersionUID = -6585754345644804597L;
	
	private Map<Integer, Map<String,ValidationObject>> testData = new HashMap<Integer, Map<String,ValidationObject>>();

	@Override
	public String getClassName() {
		return ValidationBean.class.getName();
	}
	
	public void add(int page, String id, int score, String correctAnswer) {
		if (testData.get(page) == null) {
			testData.put(page, new HashMap<String, ValidationObject>());
		}
		
		ValidationObject vo = new ValidationObject();
		vo.setScore(score);
		vo.setCorrectAnswer(correctAnswer);
		testData.get(page).put(id,vo);
	}
	
	public Map<Integer, Map<String, ValidationObject>> getTestData() {
		return testData;
	}


	public static class ValidationObject extends ScriptableObject {

		private static final long serialVersionUID = -5856832513678294878L;
		
		private int score;
		
		private String correctAnswer;
		
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public String getCorrectAnswer() {
			return correctAnswer;
		}

		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}

		@Override
		public String getClassName() {
			return ValidationObject.class.getName();
		}
	}
}
