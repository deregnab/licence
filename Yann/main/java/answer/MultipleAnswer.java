package answer;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents an answer class with a Textual type which has multiple answers(or choices). 
 * The class is initalized with a String that contains all the answers separated by a separator.
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public abstract class MultipleAnswer extends TextualAnswer {

	protected List<String> tabAnswer;
	
	/**
	 * Initializes a newly created MultipleAnswer object 
	 * @param answer all the answers of the question
	 */
	public MultipleAnswer(String answer) {
		super(answer);
		tabAnswer = new ArrayList<String>();
		String tmp = "";
		for (int i = 0 ; i < answer.length() ; i++) {
			if (answer.charAt(i) == this.getSeparator()) {
				this.tabAnswer.add(tmp.substring(0, tmp.length()-1));
				tmp = "";
				i++;
			} else {
				tmp = tmp + answer.charAt(i);
			}
		}
		this.tabAnswer.add(tmp.substring(0, tmp.length()));
	}
	
	/**
	 * Indicates if the user's answer is contained in the multiple answers of this class
	 * @param userAnswer the user's answer
	 * @return true if the user's answer is contained in the answers list
	 */
	public boolean isPossibleAnswer(String userAnswer) {
		String tmp = userAnswer.toLowerCase();
		for (String s : this.tabAnswer) {
			if (s.toLowerCase().equals(tmp)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gives the separator to find the different answers in the constructor String
	 * @return the separator char 
	 */
	protected abstract char getSeparator ();
	
}
