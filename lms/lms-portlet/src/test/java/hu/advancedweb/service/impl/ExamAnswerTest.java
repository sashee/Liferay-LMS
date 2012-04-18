package hu.advancedweb.service.impl;

import hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic;

import org.junit.Assert;
import org.junit.Test;

public class ExamAnswerTest {

	@Test
	public void testReread() throws Exception {
		String generated = new ExamConfigLocalServiceImpl().generateDefaultEvaluatorJavascript(new DefaultExamEvaluatorLogic() {
			{
				addCorrectAnswer("page1", "question1", "correctanswer1", 1);
				addCorrectAnswer("page1", "question2", "correctanswer2", 2);
				addCorrectAnswer("page2", "question12", "correctanswer12", 3);
			}
		});

		DefaultExamEvaluatorLogic reread = new ExamConfigLocalServiceImpl().rereadDefaultEvaluatorLogic(generated);
		Assert.assertTrue(reread.correctAnswers.containsKey("page1"));
		Assert.assertTrue(reread.correctAnswers.containsKey("page2"));
		Assert.assertTrue(reread.correctAnswers.size() == 2);
		Assert.assertTrue(reread.correctAnswers.get("page1").containsKey("question1"));
		Assert.assertTrue(reread.correctAnswers.get("page1").containsKey("question2"));
		Assert.assertTrue(reread.correctAnswers.get("page1").size() == 2);
		Assert.assertTrue(reread.correctAnswers.get("page1").get("question1").getValue0().compareTo("correctanswer1") == 0);
		Assert.assertTrue(reread.correctAnswers.get("page1").get("question2").getValue0().compareTo("correctanswer2") == 0);
		Assert.assertTrue(reread.correctAnswers.get("page1").get("question1").getValue1() == 1);
		Assert.assertTrue(reread.correctAnswers.get("page1").get("question2").getValue1() == 2);
		Assert.assertTrue(reread.correctAnswers.get("page2").size() == 1);
		Assert.assertTrue(reread.correctAnswers.get("page2").get("question12").getValue0().compareTo("correctanswer12") == 0);
		Assert.assertTrue(reread.correctAnswers.get("page2").get("question12").getValue1() == 3);
	}

}
