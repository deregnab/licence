package main.answertype;

import main.Answer;

public class BooleanAnswer implements Answer {

	protected boolean answer;
	@Override
	public boolean isCorrectAnswer() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * retourne une reponse de type boolean(vrai/faux)
	 * @return boolean reponse à la question
	 */
	public boolean getAnswer(){
		return answer;
	}


}
