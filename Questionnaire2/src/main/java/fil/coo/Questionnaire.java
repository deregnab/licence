package main.java.fil.coo;

import java.util.ArrayList;
import java.util.List;

import main.java.fil.coo.question.Question;
import main.java.fil.coo.view.QuestionnaireUI;



public abstract class Questionnaire {

	protected List<Question> questions;
	protected QuestionnaireUI ui;
	protected int score;

	public Questionnaire() {
		questions = new ArrayList<Question>();
		score = 0;
	}

	public abstract void askAll();
	
	/**
	 * Adds a question to the questions list.
	 * 
	 * @param question
	 *            a new question
	 */
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public List<Question> getListQuestions() {
		return this.questions;
	}
}
