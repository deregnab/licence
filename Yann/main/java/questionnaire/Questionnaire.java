package questionnaire;

import java.util.ArrayList;
import java.util.List;

import ui.QuestionnaireUI;
import ui.QuestionnaireUIConsole;

/**
 * This class represents the main elements of a questionnaire
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class Questionnaire {

	protected List<Question> theQuestions;
	protected QuestionnaireUI ui = new QuestionnaireUIConsole();
	protected int score = 0;
	
	/**
	 * Initializes a newly created Questionnaire object, with its question list
	 */
	public Questionnaire () {
		this.theQuestions = new ArrayList <Question>();
	}
	
	/**
	 * Initializes a newly created Questionnaire object, with its question list
	 * @param theQuestions the question list
	 */
	public Questionnaire (List<Question> theQuestions) {
		this.theQuestions = theQuestions;
	}
	
	/**
	 * Allows the questionnaire to ask to the user all the question in the question list
	 */
	public  void askAll() {
		for(Question question : this.theQuestions) {
			askOneQuestion(question);
		}
		this.ui.printFinalScore(score);
	}
	
	/**
	 * Allows the questionnaire to ask to the user one question (in the constructor)
	 * @param question the asked question
	 */
	public void askOneQuestion (Question question) {
		this.ui.printQuestionText(question);
		String answer = this.ui.readAnswer(question);
		while(!question.acceptAnswer(answer)) {
			answer =  this.ui.readAnswer(question);
		}
		this.checkAnswer(answer, question);
	}
	
	/**
	 * Allows the questionnaire to read an answer to the user and to verify it. If the answer is correct, the user gains the question points.
	 * @param answer the user's answer
	 * @param question the asked question
	 */
	public void checkAnswer(String answer, Question question) {
		if (question.isCorrectAnswer(answer)) {
			this.ui.printAnswerIsCorrect(question);
			this.score += question.getPoints();
		} else {
			this.ui.printAnswerIsIncorrect(question);
		}
	}
	
	/**
	 * Adds a question to the question list
	 * @param q the added question
	 */
	public void addQuestion (Question q) {
		theQuestions.add(q);
	}
	
	/**
	 * Sets a new User Interface (console or Jframe, for example)
	 * @param ui the new ui
	 */
	public void setUI(QuestionnaireUI ui) {
		this.ui = ui;
	}
	
	/**
	 * Gives the current score
	 * @return the user's score
	 */
	public int getScore () {
		return this.score;
	}
}
