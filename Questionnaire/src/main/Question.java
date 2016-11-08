package main;

public class Question {

	protected int points;
	protected String text; 
	protected Answer answer;
	
	public Question(){}
	public Question(int points,String text,Answer answer){
		this.points=points;
		this.text=text;
		this.answer=answer;
		
	}
	
	/**
	 * methode retournant le corps de la question
	 * @return la question
	 */
	public String getText(){ return text;
	}
	
	/**
	 * methode retournant la reponse � la question
	 * @return une reponse de type Reponse
	 */
	public Answer getAnswer() {
		return answer;
	}

	/**
	 * methode retournant le nombre de points de la question
	 * @return int le nombre de points de la question
	 */
	
	public int getPoints() {
		return points;
	}

	/**
	 * retourne si une reponse est valide
	 * @param question
	 * @return
	 */
	public boolean acceptAnswer(Question question) {
		return false;
	}

}
