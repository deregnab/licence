package fil.coo.answerpanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fil.coo.question.Question;

public class TextualAnswerPanel extends AnswerPanel{
	
	JTextField questionT;
	JTextArea ansArea;
	Question question;
	
	public TextualAnswerPanel(Question question){
		super(question);
		this.questionT = new JTextField(question.getText());
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
