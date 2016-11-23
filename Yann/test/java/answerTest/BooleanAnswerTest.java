package answerTest;

import answer.Answer;
import answer.BooleanAnswer;

public class BooleanAnswerTest extends AnswerGeneralTest{
	public Answer<?> createAnswer() {
		return new BooleanAnswer("oui");
	}
	
	public String createWrongType() {
		return "wrong_type";
	}
	
	public String createWrongAnswer() {
		return "non";
	}
	
	public String createRightAnswer() {
		return "oui";
	}
}
