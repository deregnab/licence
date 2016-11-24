package main.java.fil.coo.question;

import main.java.fil.coo.answer.IAnswer;

/**
 * Represents a Question. A Question is characterized by :
 * <ul>
 * <li>the text</li>
 * <li>the number of points</li>
 * <li>the answer</li>
 * </ul>
 * 
 */
public class Question {

	/**
	 * The text of the question.
	 */
	protected String text;

	/**
	 * The number of points that brings the question if correctly answered.
	 */
	protected int points;

	/**
	 * The answer of the question.
	 */
	protected IAnswer answer;

	public Question(String text, IAnswer answer, int points) {
		this.text = text;
		this.answer = answer;
		this.points = points;
	}
	
	/**
	 * Gets the text of the question.
	 * 
	 * @return the text of the question.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return The number of points given by the question if it was correctly
	 * 			answered
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Checks if the type of the answer is correct.
	 * 
	 * @param answer
	 *          	the player's answer
	 * @return <code>true</code> if the type is correct,
	 *  <code>false</code>  else.
	 */
	public boolean typeCorrect(String answer) {
		return this.answer.typeCorrect(answer);
	}

	public String getAnswerType() {
		return this.answer.getType();
	}
	
	public String getRealAnswerType() {
		return this.answer.getRealType();
	}
	

	/**
	 * Checks if the player's answer is equals to the expected answer.
	 * 
	 * @param answer
	 *          	the player's answer
	 * @return <code>true</code> if the answer is the good one,
	 *         <code>false</code> else.
	 */
	public boolean isCorrectAnswer(String answer) {
		return this.answer.isCorrectAnswer(answer);
	}

	/**
	 * Gets the correct answer of the question.
	 * 
	 * @return the correct answer of the question.
	 */
	public String getCorrectAnswer() {
		return this.answer.getCorrectAnswer();
	}

}
