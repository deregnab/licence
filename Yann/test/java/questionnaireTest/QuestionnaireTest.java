package questionnaireTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mock.MockQuestionnaireUI;
import questionnaire.Question;
import questionnaire.Questionnaire;

public class QuestionnaireTest {

	private MockQuestion question, question2;
	private MockQuestionnaireUI ui;
	private Questionnaire questionnaire;
	
	@Before
	public void setup () {
		question = new MockQuestion();
		question2 = new MockQuestion();
		this.ui = new MockQuestionnaireUI();
		List <Question> liste = Arrays.<Question>asList(question, question2);
		this.questionnaire = new Questionnaire (liste);
		questionnaire.setUI(ui);
	}

	@Test
	public void readAnswerAsLongAsItIsNotAcceptable() throws Exception {
		int nbRejectionsBeforeAccepting = 3;
		question.answerRejectionCount = nbRejectionsBeforeAccepting;
		
		assertEquals(0, question.acceptAnswerCalled);
		questionnaire.askOneQuestion(question);
		assertEquals(nbRejectionsBeforeAccepting+1, question.acceptAnswerCalled);
		assertEquals(nbRejectionsBeforeAccepting+1, this.ui.readAnswerCalled);
	}
	
	/*Mock classes Realm*/
	
	private class MockQuestion extends Question {
		
		protected int acceptAnswerCalled = 0;
		protected int answerRejectionCount = 0;
		
		public boolean acceptAnswer(String string) {
			this.acceptAnswerCalled++;
			if (this.answerRejectionCount <= 0) {
				return true;
			} else {
				this.answerRejectionCount--;
				return false;
			}
		}
		
		public boolean isCorrectAnswer(String userAnswer) {
			return false;
		}
		public MockQuestion () {
			super(null, null, 5);
		}
	}
	

	
}
