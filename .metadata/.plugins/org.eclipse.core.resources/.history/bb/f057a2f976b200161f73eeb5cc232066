package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import questionnaire.Questionnaire;

@SuppressWarnings("serial")
public class QuestionnaireFrame extends JFrame{

	Questionnaire q;
	
	public QuestionnaireFrame (Questionnaire q) {
		this.q = q;
		this.setTitle("Ma première fenêtre Java");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		//panel.add(new JButton("Hello !"));
		
		
		/**
		 * Boolean Answer
		 */
		JPanel panelBoolean = new JPanel();
		panelBoolean.setBorder(BorderFactory.createLineBorder(Color.black));
		panelBoolean.setLayout(new BoxLayout(panelBoolean, BoxLayout.X_AXIS));
		
		JPanel panelBooleanQuestion = new JPanel();
		JLabel booleanQuestion = new JLabel("Question Boolean");
		panelBooleanQuestion.add(booleanQuestion);
		panelBoolean.add(panelBooleanQuestion);
		
		JPanel panelBooleanAnswer = new JPanel();
		panelBooleanAnswer.setLayout(new BoxLayout(panelBooleanAnswer, BoxLayout.Y_AXIS));
		JCheckBox checkYes = new JCheckBox("oui");
		checkYes.setMnemonic(KeyEvent.VK_C); 
		checkYes.setSelected(false);
		panelBooleanAnswer.add(checkYes);
		JCheckBox checkNo = new JCheckBox("non");
		checkNo.setMnemonic(KeyEvent.VK_C); 
		checkNo.setSelected(false);
		panelBooleanAnswer.add(checkNo);
		panelBoolean.add(panelBooleanAnswer);
		//checkNo.setSelected(true);
		
		panelPrincipal.add(panelBoolean);
		
		/**
		 * Numerical Answer 
		 */
		JPanel panelNumerical = new JPanel();
		panelNumerical.setBorder(BorderFactory.createLineBorder(Color.black));
		//panelNumerical.setLayout(new BoxLayout(panelNumerical, BoxLayout.X_AXIS));
		
		JPanel panelNumericalQuestion = new JPanel();
		JLabel numericalQuestion = new JLabel("Question Numerical");
		panelNumericalQuestion.add(numericalQuestion);
		panelNumerical.add(panelNumericalQuestion);
		
		JSpinner numericalAnswer = new JSpinner(new SpinnerNumberModel(0, -10000, 10000, 1));
		panelNumerical.add(numericalAnswer);
		
		panelPrincipal.add(panelNumerical);
		
		
		/**
		 * TextualAnswer
		 */
		JPanel panelTextual = new JPanel();
		panelTextual.setBorder(BorderFactory.createLineBorder(Color.black));
		//panelTextual.setLayout(new BoxLayout(panelNumerical, BoxLayout.X_AXIS));
		JPanel panelTextualQuestion = new JPanel();
		JLabel textualQuestion = new JLabel("Textual question");
		panelTextualQuestion.add(textualQuestion);
		panelTextual.add(panelTextualQuestion);
		
		JPanel panelTextualAnswer = new JPanel();
		JTextField textualAnswer= new JTextField("", 20);
		panelTextualAnswer.add(textualAnswer);
		panelTextual.add(panelTextualAnswer);
		
		panelPrincipal.add(panelTextual);
		
		/*
		JPanel panelTMP = new JPanel();
		for(int i=0; i<5; i++){
			panelTMP = new JPanel();
			panelTMP.setLayout(new BoxLayout(panelTMP, BoxLayout.X_AXIS));
			panelTMP.add(new JButton(i+"gauche"));
			panelTMP.add(new JButton(i+"droite"));
			panel.add(panelTMP);
		}*/
		
		this.getContentPane().add(panelPrincipal);
		this.setVisible(true);
	}

	
}
