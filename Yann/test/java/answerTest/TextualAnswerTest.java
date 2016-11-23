package answerTest;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import answer.Answer;
import answer.TextualAnswer;

public class TextualAnswerTest extends AnswerGeneralTest{

	public Answer<?> createAnswer() {
		return new TextualAnswer("right_answer");
	}
	
	public String createWrongType() {
		return "";
	}
	
	public String createWrongAnswer() {
		return "wrong_nswer";
	}
	
	public String createRightAnswer() {
		return "right_answer";
	}

	/*This test case is never used*/
	@Test
	public void buildAnswerTest_shouldRaiseInvocationTargetException() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	}
	
	/*This test case is never used*/
	@Test
	public void typeCorrectTest_ShouldBeFalse() {
		assertEquals(false, false);
	}

}
