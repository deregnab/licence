package main.answertype;

import main.Answer;

public class TextualAnswer implements Answer {

	protected String answer;
	@Override
	public boolean isCorrectAnswer() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 *retourne une reponse de type String  
	 * @return String reponse � la question
	 */
	public String getAnswer(){
		return answer;
	}


}
