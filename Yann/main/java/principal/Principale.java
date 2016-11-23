package principal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import ihm.QuestionnaireFrame;
import questionnaire.Questionnaire;

/**
 * The main class. It creates a questionnaire with the file and asks the user the questionnaire's questions
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class Principale {

	@SuppressWarnings("unused")
	public static void main (String [] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Questionnaire qu = new Questionnaire()/*= new factory.QuestionnaireFactory().createQuestionnaire("Questionnaire.txt")*/;
		qu.askAll();
		QuestionnaireFrame qf = new QuestionnaireFrame(qu);
		//System.out.println(TrueFalse.valueOf("oui"));
	}
} 
