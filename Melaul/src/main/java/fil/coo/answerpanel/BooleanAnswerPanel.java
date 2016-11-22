package fil.coo.answerpanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fil.coo.question.Question;;

/**
 * Class creating a boolean answer panel by displaying the text of the question and a yes no box. 
 * The user can then check if the question is ever true of false by clicking on the yes or no button.
 * 
 * @author Corwin
 *
 */
public class BooleanAnswerPanel extends AnswerPanel{
	/**
	 * Declaring the needed componant for the graphic mode of a BooleanAnswer
	 */
	private Question question;
	private JTextField questionT;
	private Box box;
	private JRadioButton br1;
	private JRadioButton br2; 
	private ButtonGroup br;
	
	/**
	 * Constructor wich taking a Question in parameters, making a panel with the question's text
	 * and a yes/no radiobox
	 * 
	 * @param question
	 */
	public BooleanAnswerPanel(Question question){
		super(question);
		this.questionT = new JTextField(question.getText());
		this.questionT.setEditable(false);
		
		/**
		 * Creating a yes/no box
		 */
		box = new Box(BoxLayout.Y_AXIS);
		br1 = new JRadioButton("oui");
		br2 = new JRadioButton("non");
		br = new ButtonGroup();
		br.add(br1);
		br.add(br2);
		box.add(br1);
		box.add(br2);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(this.questionT);
		this.add(box);
	}
	/**
	 * Method permitting to get the user answer
	 * 
	 * @return oui or non
	 */
	public String getUserAnswer() {
		if(br1.isSelected()){
			return "oui";
		}
		else if(br2.isSelected()){
			return "non";
		}
		else return null;
	}
	
}
