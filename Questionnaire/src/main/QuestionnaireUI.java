package main;

public interface QuestionnaireUI {

	public void printQuestionText(Question question);
	public void printFinalScore(int score);
	public String readAnswer(IQuestion question);
}
