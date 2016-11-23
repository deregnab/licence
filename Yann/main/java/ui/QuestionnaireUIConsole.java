package ui;

import java.util.Scanner;

import questionnaire.Question;

/**
 * This class implements the display methods of the console User Interface 
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public class QuestionnaireUIConsole implements QuestionnaireUI{

	/**
	 * Prints the question's text on the console
	 * @param question the asked question
	 */
	public void printQuestionText(Question question) {
		System.out.println(question.getText());
		
	}

	/**
	 * Prints the user's final score on the console
	 * @param score the user's score
	 */
	public void printFinalScore(int score) {
		System.out.println("\n Vous avez "+score+" point(s)");
	}

	/**
	 * Read the user answer on the console
	 * @param question the asked question 
	 */
	public String readAnswer(Question question) {
		String str = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(question.getAnswerDescription()+" : ");
		str = sc.nextLine();
		return str;
	}

	/**
	 * Prints a message on the console in case the user's is correct. The message indicates the question's points 
	 * @param question the asked question 
	 */
	public void printAnswerIsCorrect(Question question) {
		if (question.getPoints() == 1) {
			System.out.println("correct (1 point)");
		} else {
			System.out.println("correct ("+question.getPoints()+" points)");
		}
	}
	
	/**
	 * Prints a message on the console in case the user's answer is incorrect. The message indicates the right answer.
	 * @param question the asked question 
	 */
	public void printAnswerIsIncorrect(Question question) {
		System.out.println("incorrect, la bonne réponse était : "+question.getAnswerRightAnswer());
	}

	
}
