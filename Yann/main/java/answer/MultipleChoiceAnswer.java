package answer;

import java.util.ArrayList;
import java.util.Random;

/**
 * This abstract class represents an answer class with a Textual type which has multiple choices.
 * The user has to choose between the multiple. Only one answer is correct. 
 * The class is initalized with a String that contains all the answers separated by a separator.
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class MultipleChoiceAnswer extends MultipleAnswer{

	/**
	 * Initializes a newly created MultipleChoiceAnswer object 
	 * @param answer all the answers of the question
	 */
	public MultipleChoiceAnswer(String answer) {
		super(answer);
	}

	/**
	 * Gives the separator to find the different answers in the constructor String
	 * @return the separator char 
	 */
	protected char getSeparator() {
		return '|';
	}
	
	/**
	 * Indicates if the user respects the answer syntax. The user's answer must be in the answer list.
	 * @param userAnswer The user's answer
	 * @return true if the user's answer syntax is correct ; false otherwise
	 */
	public boolean typeCorrect(String userAnswer) {
		return super.isPossibleAnswer(userAnswer);
	}
	
	/**
	 * Gives a description of the answer type
	 * @return the description of the type
	 */
	public String getDescription() {
		ArrayList<String> tabTmp = new ArrayList<String>(this.tabAnswer);
		
		String tmp = "(";
		while (!tabTmp.isEmpty()) {
			int nb = new Random().nextInt(tabTmp.size());
			tmp+=tabTmp.get(nb)+" - ";
			tabTmp.remove(nb);
		}
		tmp=tmp.substring(0, tmp.length()-2)+")";
		return tmp;
	}
	
	/**
	 * Gives a string with the correct answer
	 * @return the right answer in a String type
	 */
	public String getRightAnswer() {
		return this.tabAnswer.get(0);
	}

}
