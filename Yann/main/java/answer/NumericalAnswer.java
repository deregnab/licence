package answer;

/**
 * This class represents an Answer class with a Integer type.
 * @author Yann GARBE - Thomas Houset
 *
 */
public class NumericalAnswer extends Answer<Integer>{

	/**
	 * Initializes a newly created NumericalAnswer object 
	 * @param answer the answer of a question 
	 */
	public NumericalAnswer(Integer answer) {
		super(answer);
	}

	/**
	 * Initializes a newly created NumericalAnswer object 
	 * @param answer A string of an Answer, which will be Integer casted 
	 */
	public NumericalAnswer(String answer) {
		super(Integer.parseInt(answer));
	}
	
	/**
	 * Indicates if the user respects the answer syntax. The user's answer must be an Integer
	 * @param userAnswer The user's answer
	 * @return true if the user's answer syntax is correct ; false otherwise
	 */
	public boolean typeCorrect(String userAnswer) {
		try {
			Integer.parseInt(userAnswer);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Indicates if the user's answer is correct
	 * @param userAnswer The userAnswer
	 * @return true if the user's answer is correct ; false otherwise
	 */
	public boolean isCorrectAnswer(String userAnswer) {
		Integer tmp = Integer.parseInt(userAnswer);
		if (tmp.equals(answer)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gives a description of the Answer type
	 * @return the description of the type
	 */
	public String getDescription() {
		return "(numerique)";
	}

}
