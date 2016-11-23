package questionnaire;

import answer.Answer;
import jPanelAnswer.JPanelAnswer;

/**
 * This class represents the main elements of a question. 
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class Question {
	
	private String text;
	private Answer<?> answer;
	private int nbPoints;
	@SuppressWarnings("unused")
	private JPanelAnswer panel;
	
	/**
	 * Initializes a newly created Question object 
	 * @param text the question's text
	 * @param answer the question's answer
	 * @param nbPoints the question's points
	 */
	public Question (String text, Answer<?> answer, int nbPoints) {
		this.text =  text;
		this.answer = answer;
		this.nbPoints = nbPoints;
	}

	/**
	 * Indicates if the user's answer is correct
	 * @param answer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean acceptAnswer(String answer) {
		return this.answer.typeCorrect(answer);
	}
	
	/**
	 * Gives the question's text
	 * @return the question's text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Indicates if the user's answer is correct
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean isCorrectAnswer(String userAnswer) {
		return this.answer.isCorrectAnswer(userAnswer);
	}
	/**
	 * Gives the question's points 
	 * @return the question's points
	 */
	public int getPoints() {
		return this.nbPoints;
	}
	
	/**
	 * Gives a description of the answer type
	 * @return the description of the type
	 */
	public String getAnswerDescription() {
		return this.answer.getDescription();
	}
	
	/**
	 * Gives a string with the correct answer
	 * @return the right answer in a String type
	 */
	public String getAnswerRightAnswer() {
		return this.answer.getRightAnswer();
	}
	
	public void setPanel (JPanelAnswer newPanel) {
		this.panel = newPanel;
	}
}
