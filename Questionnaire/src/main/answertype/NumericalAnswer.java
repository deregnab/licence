package main.answertype;

import main.Answer;

public class NumericalAnswer implements Answer{

	int answer;
	
	@Override
	public boolean isCorrectAnswer() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * retourne la reponse de type numerique
	 * @return int reponse � la question
	 */
	public int getAnswer(){
		return answer;
	}

}
