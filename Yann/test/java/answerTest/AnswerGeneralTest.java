package answerTest;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

import answer.Answer;

public abstract class AnswerGeneralTest {

	protected Answer<?> answer;
	protected String wrongType;
	protected String wrongAnswer;
	protected String rightAnswer;
	
	@Before
	public void init() {
		this.answer = this.createAnswer();
		this.wrongType = this.createWrongType();
		this.wrongAnswer = this.createWrongAnswer();
		this.rightAnswer = this.createRightAnswer();
	}
	
	public abstract Answer<?> createAnswer();
	public abstract String createWrongType();
	public abstract String createWrongAnswer();
	public abstract String createRightAnswer();
	
	@Test
	public void typeCorrectTest_ShouldBeFalse() {
		assertEquals(false, this.answer.typeCorrect(this.wrongType));
	}
	
	@Test
	public void typeCorrectTest_ShouldBeTrue() {
		assertEquals(true , this.answer.typeCorrect(this.wrongAnswer));
		assertEquals(true , this.answer.typeCorrect(this.rightAnswer));
	}
	
	@Test
	public void isCorrectAnswerTest_ShouldBeFalse() {
		assertEquals(false, this.answer.isCorrectAnswer(this.wrongAnswer));
	}
	
	@Test
	public void isCorrectAnswerTest_ShouldBeTrue() {
		assertEquals(true, this.answer.isCorrectAnswer(this.rightAnswer));
	}
	
	@Test
	public void buildAnswerTest_shouldBeAlright() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		new factory.AnswerFactory().buildAnswer(this.answer.getRightAnswer(), this.answer.getClass().getSimpleName());
	}
	
	@Test(expected=InvocationTargetException.class)
	public void buildAnswerTest_shouldRaiseInvocationTargetException() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		new factory.AnswerFactory().buildAnswer(null, this.answer.getClass().getSimpleName());
	}
	
}
