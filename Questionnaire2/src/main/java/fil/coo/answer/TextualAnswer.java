package main.java.fil.coo.answer;

/**
This class extends Answer with the generic type Textual in order to answer Textual questions
* @author Benjamin
*
*/
public class TextualAnswer extends Answer<String> {

	public TextualAnswer(String answer) {
		super(answer);
	}

	/**
	 * @see IAnswer#typeCorrect(String)
	 */
	public boolean typeCorrect(String answ) {
		System.out.println("TextualAnswer : typeCorrect entered");
		return true;
	}

	/**
	 * @see IAnswer#isCorrectAnswer(String)
	 */
	public boolean isCorrectAnswer(String answ) {
		return this.answer.equals(answ.toLowerCase());
	}

	/**
	 * @see IAnswer#getCorrectAnswer()
	 */
	public String getCorrectAnswer() {
		return this.answer;
	}

	public String getType() {
		return "symbolique";
	}
	
	public String getRealType(){
		return "textual";
	}

}
