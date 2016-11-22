package fil.coo;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fil.coo.answerpanel.AnswerPanel;
import fil.coo.factory.AnswerPanelFactory;
import fil.coo.question.Question;
import fil.coo.view.QuestionnaireUI;

public class Graphic extends JFrame implements ActionListener, QuestionnaireUI {

	int points=0;
	private List<AnswerPanel> listPanel;
	
	public Graphic(Questionnaire questionnaire) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		JScrollPane scrollPane;
		JPanel principlePanel = new JPanel();
		List<Question> listQuestions = questionnaire.getListQuestions();
		Button finishButton = new Button("J'ai fini");
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	    int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; 
	    
		listPanel = new ArrayList<AnswerPanel>();
		
		for(Question q : listQuestions){
			System.out.println(q.getRealAnswerType());
			listPanel.add(AnswerPanelFactory.FACTORY.buildAnswerPanel(q, q.getRealAnswerType()));
		}
		
		//On définit le layout à utiliser sur le content pane
		//5 lignes sur 1 colonnes

		principlePanel.setLayout(new BoxLayout( principlePanel, BoxLayout.Y_AXIS ));
		for (int i=0;i<listPanel.size();i++){
			principlePanel.add(listPanel.get(i));
		}
		principlePanel.add(finishButton);
		scrollPane = new JScrollPane(principlePanel,v,h);
		scrollPane.setPreferredSize(new Dimension(600,600));
		scrollPane.setBounds(150,670,850,200);
		
		
		finishButton.addActionListener(this);
		
		this.setTitle("Questionnaire GraphicMode");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(scrollPane);
		this.getContentPane().setBackground(Color.gray);
		this.pack();
		this.setVisible(true);

	}      



/*

	public static void main (String args[]){
		String fileName = "res/quest_tolkien.txt";
		QuestionnaireConsole questionnaire = null;

		try {
			questionnaire = QuestionnaireFactory.FACTORY.createQuestionnaire(fileName);
			for(int i=0;i<questionnaire.getListQuestions().size();i++){
				System.out.println(questionnaire.getListQuestions().get(i).getAnswerType());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Graphic graphic = new Graphic(questionnaire);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

*/



	public void actionPerformed(ActionEvent e) {
		for(AnswerPanel ap : listPanel){
			points+=ap.isGoodAnswerAddPoints();
		}
		System.out.println(points);

	}




	public void printQuestionText(Question question) {
		// TODO Auto-generated method stub
		
	}




	public void printFinalScore(int score) {
		// TODO Auto-generated method stub
		
	}




	public String readAnswer(Question question) {
		// TODO Auto-generated method stub
		return null;
	}



	/*
	//Boolean Question
	BooleanAnswer answ1=new BooleanAnswer("oui");
	Question quest1 = new Question("Question oui non",answ1 , 3);
	BooleanAnswerPanel pan1= new BooleanAnswerPanel(quest1);
	listPanel.add(pan1);

	//Numerical Question
	NumericalAnswer answ2 = new NumericalAnswer("2");
	Question quest2 = new Question("1 + 1 = ?", answ2, 1);
	NumericalAnswerPanel pan2 = new NumericalAnswerPanel(quest2);
	listPanel.add(pan2);

	//Textual Question
	TextualAnswer answ3 = new TextualAnswer("toto");
	Question quest3 = new Question("la réponse est toto", answ3, 5);
	TextualAnswerPanel pan3 = new TextualAnswerPanel(quest3);
	listPanel.add(pan3);

	TextualAnswer answ4 = new TextualAnswer("toto");
	Question quest4 = new Question("la réponse est toto", answ3, 5);
	TextualAnswerPanel pan4 = new TextualAnswerPanel(quest3);
	listPanel.add(pan4);

	TextualAnswer answ5 = new TextualAnswer("toto");
	Question quest5 = new Question("la réponse est toto", answ3, 5);
	TextualAnswerPanel pan5 = new TextualAnswerPanel(quest3);
	listPanel.add(pan5);

	 */

}
