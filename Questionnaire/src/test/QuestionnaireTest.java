package test;

import java.util.Arrays;

import org.junit.Before;

import main.Questionnaire;

public class QuestionnaireTest {

	private MockQuestion question, question2;
	private MockQuestionnaireUI ui;
	private Questionnaire questionnaire;
	
	@Before
	public void setup(){
		question = new MockQuestion();
		question2= new MockQuestion();
		this.ui=new MockQuestionnaireUI();
		this.questionnaire=new Questionnaire(Arrays.asList(question,question2));
		questionnaire.setUI(ui);
	}
	
	
}
