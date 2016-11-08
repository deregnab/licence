package main;

import java.util.List;

import test.MockQuestion;

public class Questionnaire {

	
	protected List<Question> qlist;
	protected QuestionnaireUI ui =new QuestionnaireUIConsole();
	protected int score=0;
	
	
	public Questionnaire(List<Question> qlist,QuestionnaireUI ui ) {
		this.qlist=qlist;
		this.ui=ui;
		
	}

	/**
	 * Cette fonction sans param�tre permet de poser toutes les questions du questionnaire 
	 */
	public void askAll(){
		
		for(Question question:this.qlist){
			
			askOneQuestion(question);
		}
		this.ui.printFinalScore(score);
	}

	/**
	 * Cette methode permet de poser la question poser en param�tre et � obtenir la r�ponse
	 * @param question Question pos�e au joueur
	 */
	private void askOneQuestion(Question question) {
		this.ui.printQuestionText(question);
		String answer =this.ui.readAnswer(question);
		while(!question.acceptAnswer(question)){
			
			this.CheckAnswer(answer,question);
		}
	}

	/**
	 * cette methode compare si la reponse answer et semblable � la reponse attendue pour la question question et donne des points en cas 
	 * de bonne reponse
	 * @param answer reponse propos�e par le joueur
	 * @param question question � laquelle le joueur a repondue
	 */
	private void CheckAnswer(String answer, Question question) {
		if(answer==question.getAnswer()){
			score+=question.getPoints();
			
		}
		
	}
}