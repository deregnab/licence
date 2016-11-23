package questionnaireTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mock.MockQuestionnaireUI;
import questionnaire.Question;
import questionnaire.Questionnaire;

public class OtherQuestionnaireTest {

	private Questionnaire qu;
	
	@Before
	public void init () {
		qu = new Questionnaire();
		qu.setUI(new MockQuestionnaireUI());
	}
	@Test
	public void checkAnswerTest_shouldBeFalse() {
		assertEquals(0, qu.getScore());
		qu.checkAnswer(null, new MockQuestion(false));
		assertEquals(0, qu.getScore());
	}
	
	@Test
	public void checkAnswerTest_shouldBeTrue() {
		assertEquals(0, qu.getScore());
		qu.checkAnswer(null, new MockQuestion(true));
		assertEquals(5, qu.getScore());
	}
	
	/*Mock Classes Realm*/
	
	private class MockQuestion extends Question {

		private boolean rep;
		
		public MockQuestion(boolean rep) {
			super(null, null, 5);
			this.rep = rep;
		}
		
		
		public boolean isCorrectAnswer(String answer) {
			return rep;
		}
		
	}
}
