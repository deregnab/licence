package fil.coo.view;

import java.util.Scanner;

import fil.coo.question.Question;

/**
 * The User Interface adapted for a console environment. The questions are here
 * displayed question by question, it is obligated to answer a question to
 * access the next one. 
 * About the answer, it is validated only if the input type is the expected type.
 * 
 * @author dambrine
 *
 */
public class QuestionnaireUIConsole implements QuestionnaireUI {

	/**
	 * @see QuestionnaireUI#printQuestionText(Question)
	 */
	public void printQuestionText(Question question) {
		System.out.println("(" + question.getAnswerType() + ")" + question.getText());
	}

	/**
	 * @see QuestionnaireUI#printFinalScore(int)
	 */
	public void printFinalScore(int score) {
		System.out.println("\nVous avez " + score + " points.");
	}

	/**
	 * @see QuestionnaireUI#readAnswer(Question)
	 */
	public String readAnswer(Question question) {

		Scanner sc = new Scanner(System.in);
		
		return sc.nextLine();
	}

}
