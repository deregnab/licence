package answer;

import other.TrueFalse;

/**
 * This class represents an answer class with a Boolean type. It uses the TrueFalse enum.
 * @author Yann GARBE - Thomas Houset
 *
 */
public class BooleanAnswer extends Answer<Boolean>{
	
	/**
	 * Initializes a newly created BooleanAnswer object 
	 * @param answer the answer of a question 
	 */
	public BooleanAnswer(Boolean answer) {
		super(answer);
	}
	
	/**
	 * Initializes a newly created BooleanAnswer object 
	 * @param answer A string of an answer, which will be Boolean casted 
	 */
	public BooleanAnswer(String answer) {
		super(Boolean.parseBoolean(TrueFalse.valueOf(answer).toString())); 
	}

	/**
	 * Indicates if the user respects the answer syntax. The user's answer must be "oui" or "non" 
	 * @param userAnswer The user's answer
	 * @return true if the user's answer syntax is correct ; false otherwise
	 */
	public boolean typeCorrect(String userAnswer) {
		for (int i = 0 ; i < other.TrueFalse.values().length ; i++ ) {
			if (userAnswer.equals(other.TrueFalse.values()[i].name())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Indicates if the user's answer is correct
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean isCorrectAnswer(String userAnswer) {
		Boolean tmp = Boolean.parseBoolean(TrueFalse.valueOf(userAnswer).toString());
		if (this.answer.equals(tmp)) {
			return true;
		}
		return false;
	}

	/**
	 * Gives a string with the correct answer
	 * @return the right answer in a String type
	 */
	public String getRightAnswer () {
		int i = 0;
		String rep = "-";
		while ( i < other.TrueFalse.values().length) {
			if (TrueFalse.values()[i].toString().equals(this.answer.toString())) {
				rep = TrueFalse.values()[i].name();
				break;
			}
			i++;
		}
		return rep;
	}
	
	/**
	 * Gives a description of the answer type
	 * @return the description of the type
	 */
	public String getDescription() {
		return "(oui/non)";
	}

}
