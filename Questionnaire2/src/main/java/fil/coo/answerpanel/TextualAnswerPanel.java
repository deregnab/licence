package main.java.fil.coo.answerpanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.java.fil.coo.question.Question;


/**
 * This class creates a Panel for a Textual Answer. This class extends AnswerPanel in order to adapt the user interface
 *
 */
@SuppressWarnings("serial")
public class TextualAnswerPanel extends AnswerPanel{
	
	JTextField questionT;
	JTextArea ansArea;
	Question question;
	
	/**
	 * Create a Panel for TextualAnswer
	 * @param question the question to ask to the player
	 */
	public TextualAnswerPanel(Question question){
		super(question);
		this.questionT = new JTextField(question.getText());
		questionT.setHorizontalAlignment(JTextField.CENTER);
		this.questionT.setEditable(false);
		ansArea=new JTextArea(5,30);
		ansArea.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(this.questionT);
		this.add(ansArea);
	}

	public String getUserAnswer() {
		return ansArea.getText();
	}
	
	

}
