package answer;

/**
 * This class represents an Answer class with a String type.
 * @author Yann GARBE - Thomas Houset
 *
 */
public class TextualAnswer extends Answer<String>{
	
	/**
	 * Initializes a newly created TextualAnswer object 
	 * @param answer the answer of a question 
	 */
	public TextualAnswer(String answer) {
		super(answer);
	}

	/**
	 * Indicates if the user respects the answer syntax.
	 * @param userAnswer The user's answer
	 * @return always true in this case
	 */
	public boolean typeCorrect(String userAnswer) {
		return true;
	}

	/**
	 * Indicates if the user's answer is correct
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean isCorrectAnswer(String userAnswer) {
		String tmp = userAnswer.toLowerCase();
		if (this.getRightAnswer().toLowerCase().equals(tmp)) {
			return true;
		}
		return false;
	}

	/**
	 * Gives a description of the Answer type
	 * @return the description of the type
	 */
	public String getDescription() {
		return "(symbolique)";
	}

}
