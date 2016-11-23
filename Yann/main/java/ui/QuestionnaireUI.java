package ui;

import questionnaire.Question;

/**
 * This interface represents the main methods of a questionnaire User Interface
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public interface QuestionnaireUI {

	/**
	 * Prints the question's text
	 * @param question the asked question
	 */
	public void printQuestionText(Question question);
	
	/**
	 * Prints the user's final score
	 * @param score the user's score
	 */
	public void printFinalScore(int score);
	
	/**
	 * Prints a message in case the user's is correct
	 * @param question the asked question 
	 */
	public void printAnswerIsCorrect(Question question);
	
	/**
	 * Prints a message in case the user's answer is incorrect
	 * @param question the asked question 
	 */
	public void printAnswerIsIncorrect (Question question);
	
	/**
	 * Read the user answer
	 * @param question the asked question 
	 */
	public String readAnswer(Question question);
	
}
