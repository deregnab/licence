package main.java.fil.coo.answer;

/**
  This class extends Answer with the generic type Numerical in order to answer Numerical questions
 * @author Benjamin
 *
 */
public class NumericalAnswer extends Answer<Integer> {

	public NumericalAnswer(String answer) {
		super(answer);
	}

	/**
	 * @see IAnswer#typeCorrect(String)
	 */
	public boolean typeCorrect(String answ) {

		try {
			Integer.parseInt(answ);
			return true;
		} catch (NumberFormatException nfe) {
		}
		return false;
	}

	/**
	 * @see IAnswer#isCorrectAnswer(String)
	 */
	public boolean isCorrectAnswer(String answ) {

		if (typeCorrect(answ)) {
			return Integer.parseInt(answ) == Integer.parseInt(this.answer);
		}
		return false;
	}

	/**
	 * @see IAnswer#getCorrectAnswer()
	 */
	public String getCorrectAnswer() {

		return this.answer + "";
	}

	public String getType() {
		return "numerical";
	}
	
	public String getRealType() {
		return "numerical";
	}
}
