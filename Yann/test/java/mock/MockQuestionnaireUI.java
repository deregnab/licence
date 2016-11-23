package mock;

import questionnaire.Question;
import ui.QuestionnaireUI;

public class MockQuestionnaireUI implements QuestionnaireUI {

	public  int readAnswerCalled = 0;
		
	public String readAnswer(Question question) {
		this.readAnswerCalled++;
		return null;
	}		
	public void printQuestionText(Question question) {}
	public void printFinalScore(int score) {}
	public void printAnswerIsCorrect(Question question) {}
	public void printAnswerIsIncorrect(Question question) {}
}
