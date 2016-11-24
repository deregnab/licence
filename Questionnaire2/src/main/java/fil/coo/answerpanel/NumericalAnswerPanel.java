package main.java.fil.coo.answerpanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import main.java.fil.coo.question.Question;

/**
 * This class creates a Panel for a Numerical Answer. This class extends AnswerPanel in order to adapt the user interface
 *
 */
@SuppressWarnings("serial")
public class NumericalAnswerPanel extends AnswerPanel{

	private JTextField textQuestion;
	private JSpinner spinner;
	private Question question;

	/**
	 * Create a Panel for NumericalAnswer
	 * @param question the question to ask to the player
	 */
	public NumericalAnswerPanel(Question question){
		super(question);
		this.textQuestion = new JTextField(question.getText());
		this.textQuestion.setEditable(false);

		spinner = new JSpinner(new SpinnerNumberModel());
		spinner.setValue(0);
		spinner.setEnabled(true);
		JComponent field = ((JSpinner.DefaultEditor) spinner.getEditor());
		Dimension prefSize = field.getPreferredSize();
		prefSize = new Dimension(100, prefSize.height);
		field.setPreferredSize(prefSize);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(textQuestion);
		this.add(spinner);
	}

	public String getUserAnswer() {

		return spinner.getValue() + "";
	}


}
