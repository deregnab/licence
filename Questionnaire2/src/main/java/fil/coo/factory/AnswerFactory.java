package main.java.fil.coo.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import main.java.fil.coo.answer.IAnswer;



public class AnswerFactory {

	public static final AnswerFactory FACTORY = new AnswerFactory();

	private AnswerFactory() {
	}

	public IAnswer buildAnswer(String answer, String type) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		System.out.println("answer : " + answer + " - type : " + type);
		
		String className = getClassName(type);
		try {
			@SuppressWarnings("unchecked")
			Class<? extends IAnswer> sc = (Class<? extends IAnswer>) Class.forName("main.java.fil.coo.answer." + className);
			Constructor<? extends IAnswer> cons = sc.getConstructor(java.lang.String.class);
			IAnswer a = cons.newInstance(answer);
			return a;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getClassName(String type) {
		type = type.toLowerCase();
		char c = type.charAt(0);
		return (c + "").toUpperCase() + type.substring(1) + "Answer";
	}
}
