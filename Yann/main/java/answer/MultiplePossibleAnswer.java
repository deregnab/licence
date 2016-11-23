package answer;

/**
 * This abstract class represents an answer class with a Textual type which has multiple answer.
 * The user's answer has to be in the answer list to be correct.
 * The class is initalized with a String that contains all the answers separated by a separator.
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class MultiplePossibleAnswer extends MultipleAnswer{

	/**
	 * Initializes a newly created MultiplePossibleAnswer object 
	 * @param answer all the answers of the question
	 */
	public MultiplePossibleAnswer(String answer) {
		super(answer);
	}

	/**
	 * Indicates if the user's answer is correct. The user's answer must be in the answer list.
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean isCorrectAnswer(String userAnswer) {
		return super.isPossibleAnswer(userAnswer);
	}
	
	/**
	 * Gives a description of the answer type
	 * @return the description of the type
	 */
	public String getDescription() {
		return "("+this.tabAnswer.size()+" réponses possibles)";
	}

	/**
	 * Gives the separator to find the different answers in the constructor String
	 * @return the separator char 
	 */
	protected char getSeparator() {
		return ';';
	}
}
