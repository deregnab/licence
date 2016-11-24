package main.java.fil.coo.answerpanel;

import javax.swing.JPanel;

import main.java.fil.coo.question.Question;

/**
 * Abstract class with the purpose of guiding
 * the specific subclass depending of their type.
 * 
 * @author Corwin
 *
 */
public abstract class AnswerPanel extends JPanel{

	private Question question;
	
	public AnswerPanel(Question question){
		this.question=question;
	}
	
	/**
	 * Abstract method that will be implemented in each sub-classes, depending of there types.
	 * 
	 * @return user answer
	 */
	public abstract String getUserAnswer();
	
		
	/**
	 * A method that permit to add points to the user if he's right.
	 * 
	 * @return the points aquired by the user
	 */
	public int isGoodAnswerAddPoints(){
		if(question.isCorrectAnswer(this.getUserAnswer())){
			return question.getPoints();
		}
		else return 0;
	}
}
