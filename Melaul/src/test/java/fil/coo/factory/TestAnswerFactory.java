package fil.coo.factory;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class TestAnswerFactory {

	@Test
	public void testBuildAnswer() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		String answer = "Tolkien";
		String type = "textual";
		
		assertNotNull(AnswerFactory.FACTORY.buildAnswer(answer, type));
	}
	
	@Test
	public void testGetClassName() {
		String type = "textual";
		String type2 = "numerical";
		String type3 = "boolean";
		
		assertTrue(AnswerFactory.FACTORY.getClassName(type).equals("TextualAnswer"));
		assertTrue(AnswerFactory.FACTORY.getClassName(type2).equals("NumericalAnswer"));
		assertTrue(AnswerFactory.FACTORY.getClassName(type3).equals("BooleanAnswer"));
	}
}
