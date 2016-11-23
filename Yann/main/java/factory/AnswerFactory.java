package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import answer.*;

/**
 * This class represents a design pattern factory that creates any type of Answer class in term of the String typeAnswer
 * @author Yann GARBE - Thomas HOUSET
 */
public class AnswerFactory {

	/**
	 * Creates a answer in term of a String
	 * @param a the answer text
	 * @param typeAnswer the type of the Answer (to create the right Answer class)
	 * @return the created Answer
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Answer buildAnswer(String a, String typeAnswer) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String type = "answer."+typeAnswer;
		
		Class <? extends Answer> classAnswer = (Class<? extends Answer>) Class.forName(type);
		Constructor <? extends Answer> cons = classAnswer.getConstructor(String.class);
		Answer rep = cons.newInstance(a);
		/*rep.setPanel(this.buildJPanelAnswer(rep, typeAnswer));*/
		return rep;
	}
	

	
}
