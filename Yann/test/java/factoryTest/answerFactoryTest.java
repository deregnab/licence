package factoryTest;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class answerFactoryTest {

	@Test(expected=ClassNotFoundException.class)
	public void buildAnswerTest_ShouldRaiseClassNotFoundException() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		new factory.AnswerFactory().buildAnswer("", "notAnAnswerClass");
	}
	
}
