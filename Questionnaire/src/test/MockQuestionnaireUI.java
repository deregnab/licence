package test;

import main.IQuestion;
import main.Question;
import main.QuestionnaireUI;

public class MockQuestionnaireUI implements QuestionnaireUI {

	protected int readAnswerCalled=0;

	@Override
	public void printQuestionText(Question question) {

	}

	@Override
	public void printFinalScore(int score) {

	}

	@Override
	public String readAnswer(IQuestion question) {
		this.readAnswerCalled++;
		return null;
	}

}
