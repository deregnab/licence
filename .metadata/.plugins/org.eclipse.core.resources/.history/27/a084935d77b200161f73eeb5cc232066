package fil.coo.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import fil.coo.Questionnaire;
import fil.coo.QuestionnaireConsole;
import fil.coo.QuestionnaireGraphical;
import fil.coo.answer.IAnswer;
import fil.coo.question.Question;

/**
 * Factory creating Questionnaire instances using a given fileName.
 * 
 * @author dambrine
 *
 */
public class QuestionnaireFactory {

	public static final QuestionnaireFactory FACTORY = new QuestionnaireFactory();
	
	private QuestionnaireFactory() {
	}
	
	public Question createQuestion(String text, String answer, String type, String points) throws IOException {

		System.out.println(
				"createQuestion called with $" + text + "$, $" + answer + "$, $" + type + "$, $" + points + "$");

		try {
			int nbPoints = Integer.parseInt(points);
			System.out.println("Parsed value : " + nbPoints);
			try {
				IAnswer answ = AnswerFactory.FACTORY.buildAnswer(answer, type);
				return new Question(text, answ, nbPoints);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException nfe) {
			throw new IOException("bad format");
		}

		return null;
	}

	public Questionnaire createQuestionnaire(String fileName, boolean isGraphicUI) throws IOException {
		
		Questionnaire questionnaire = this.initQuestionnaire(isGraphicUI);
		File source = new File(fileName);
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(source));
			String text;
			while ((text = in.readLine()) != null) {
				System.out.println("Text : " + text);

				String answer = in.readLine().toLowerCase();
				System.out.println("Answer : " + answer);

				String nbPoints = in.readLine();
				System.out.println("nbPoints : " + nbPoints);

				String type = in.readLine();
				System.out.println("Type : " + type);				

				if (answer == null || nbPoints == null || type == null) {
					throw new IOException("bad format");
				}
				questionnaire.addQuestion(this.createQuestion(text, answer, type, nbPoints));
			}
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		} finally {
			in.close();
		}

		return questionnaire;
	}
	
	private Questionnaire initQuestionnaire(boolean isGraphicUI) {
		if (isGraphicUI)
			return new QuestionnaireGraphical();
		else
			return new QuestionnaireConsole();
	}
}
