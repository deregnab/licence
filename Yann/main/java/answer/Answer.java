package answer;

/**
 * 
 * This generic abstract class represents the 'root' class of the answer classes. It contains the necessary methods for an answer class
 * @author Yann GARBE - Thomas HOUSET
 *
 * @param <T> the type of the answer (String, Integer and Boolean for now) 
 */
public abstract class Answer<T>{
	
	protected T answer;

	/**
	 * Initializes a newly created Answer object 
	 * @param answer the answer of a question 
	 */
	public Answer (T answer) {
		this.answer = answer;
	}
	
	/**
	 * Indicates if the user respects the answer syntax
	 * @param userAnswer The user's answer
	 * @return true if the user's answer syntax is correct ; false otherwise
	 */
	public abstract boolean typeCorrect(String userAnswer);
	
	/**
	 * Indicates if the user's answer is correct
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public abstract boolean isCorrectAnswer(String userAnswer);
	
	/**
	 * Gives a string with the correct answer
	 * @return the right answer in a String type
	 */
	public String getRightAnswer () {
		return this.answer.toString();
	}
	
	/**
	 * Gives a description of the answer type
	 * @return the description of the type
	 */
	public abstract String getDescription();
	

}
