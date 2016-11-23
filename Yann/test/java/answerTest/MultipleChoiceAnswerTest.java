package answerTest;

import answer.Answer;
import answer.MultipleChoiceAnswer;

public class MultipleChoiceAnswerTest extends AnswerGeneralTest{

	
	public Answer<?> createAnswer() {
		return new MultipleChoiceAnswer("answer_one | answer_two | answer_three");
	}

	public String createWrongType() {
		return "wrong_type";
	}

	public String createWrongAnswer() {
		return "answer_two";
	}

	public String createRightAnswer() {
		return "answer_one";
	}
	
	

}
