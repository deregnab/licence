package factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import jPanelAnswer.JPanelAnswer;
import questionnaire.Question;
import questionnaire.Questionnaire;

/**
 * This class represents a design pattern factory that can create a Questionnaire class and a Question class 
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class QuestionnaireFactory {
	
	/**
	 * Create a new Question in term of the parameters
	 * @param text the text's question
	 * @param answer the answer's question
	 * @param points the question's points
	 * @param typeAnswer the answer's type (used in the AnswerFactory)
	 * @return the createdQuestion
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Question createQuestion (String text, String answer, String points, String typeAnswer) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question (text, new factory.AnswerFactory().buildAnswer(answer, typeAnswer), nbPoints);
		}catch (NumberFormatException e) {
			throw new IOException ("Bad Format");
		}
	}
	
	/**
	 * Create a new Questionnaire in term the file name. Each file line will be analyzed to take the question informations
	 * @param fileName the name of the file
	 * @return the created Questionnaire
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Questionnaire createQuestionnaire (String fileName) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Questionnaire questionnaire = new Questionnaire();
		File source = new File (fileName);
		BufferedReader in = null;
		try {
			in = new BufferedReader (new  FileReader(source));
			String text;
			// read block of 4 lines : text, answer, number of points and type of answer
			while ((text = in.readLine()) != null) {
				
				String answer = in.readLine();
				String nbPoints = in.readLine();
				String typeAnswer = in.readLine();
				if (answer == null || nbPoints ==  null || typeAnswer == null) {
					throw new IOException ("Bad Format");
				}
				Question tmp = this.createQuestion(text, answer, nbPoints, typeAnswer);
				tmp.setPanel(buildJPanelAnswer(tmp, typeAnswer/*, bla bla bla*/));
				questionnaire.addQuestion(tmp);
				
			}
		} catch (FileNotFoundException e) {
			throw new IOException (e);
		} 
		finally {
			in.close();
		}
		return questionnaire;
	}
	
	@SuppressWarnings({ "unchecked" })
	private JPanelAnswer buildJPanelAnswer(Question q, String typeAnswer/*, bla bla bla*/) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String panelType = "jPanelAnswer.JPanel"+typeAnswer;
		 Class <? extends JPanelAnswer> classPanelAnswer = (Class<? extends JPanelAnswer>) Class.forName(panelType);
		Constructor <? extends JPanelAnswer> panelCons = classPanelAnswer.getConstructor(Question.class);
		return panelCons.newInstance(q);
	}
}
