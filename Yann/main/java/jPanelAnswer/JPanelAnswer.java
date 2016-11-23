package jPanelAnswer;

import javax.swing.JPanel;

import questionnaire.Question;

@SuppressWarnings("serial")
public abstract class JPanelAnswer extends JPanel{

	Question q;
	
	public JPanelAnswer (Question q) {
		this.q = q;
	}
	
	public abstract JPanel JPanelDisplay();
}
