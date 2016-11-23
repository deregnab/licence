package answerTest;

import answer.Answer;
import answer.MultiplePossibleAnswer;

public class MultiplePossibleAnswerTest extends TextualAnswerTest{
	public Answer<?> createAnswer() {
		return new MultiplePossibleAnswer("answer_one ; answer_two ; answer_three");
	}
	
	public String createWrongType() {
		return "";
	}
	
	public String createWrongAnswer() {
		return "wrong_answer";
	}
	
	public String createRightAnswer() {
		return "answer_three";
	}
}
