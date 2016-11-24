package main.java.fil.coo.answer;

/** 
 * IAnswer implements the methods which will be used by the answers of the Quiz
 * 
 *  */
public interface IAnswer {

	/**
	 * Checks if the filled answer is correct in its type.
	 * 
	 * @param answer 
	 *			the player's answer
	 * @return <code>true</code> if the type of the answer is correct,
	 *         <code>false</code> else.
	 */
	public boolean typeCorrect(String answer);

	/**
	 * Checks if the filled answer is the correct answer.
	 * 
	 * @param answer
	 *			the player's answer
	 * @return <code>true</code> if the filled answer is the good one,
	 *         <code>false</code> else.
	 */
	public boolean isCorrectAnswer(String answer);

	/**
	 * Return the expected answer of the Question
	 * 
	 * @return the correct answer.
	 */
	public String getCorrectAnswer();

	/**
	 * Gets the type of the Question's answer
	 * 
	 * @return the type of the answer.
	 */
	public String getType();
	
	public String getRealType();
}
