package answerTest;

import answer.Answer;
import answer.NumericalAnswer;

public class NumericalAnswerTest extends AnswerGeneralTest{
	public Answer<?> createAnswer() {
		return new NumericalAnswer("1885");
	}
	
	public String createWrongType() {
		return "wrong_type";
	}
	
	public String createWrongAnswer() {
		return "1";
	}
	
	public String createRightAnswer() {
		return "1885";
	}
}
