package test;

import main.Answer;
import main.Question;

public class MockQuestion extends Question {

	
	protected int acceptAnswerCalled = 0;
	protected int answerRejectionCount=0;
	
	public boolean AcceptAnswer(String string ){
		
		this.acceptAnswerCalled++;
		if(this.answerRejectionCount<=0){
			return true;
			
		}else{
			this.answerRejectionCount--;
			return false;
		}
		
	}
	


}
