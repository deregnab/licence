package fil.coo.answer;

public class BooleanAnswer extends Answer<Boolean> {

	public BooleanAnswer(String answer) {
		super(answer);
	}

	public boolean typeCorrect(String answ) {

		System.out.println("BooleanAnswer : typeCorrect called with {" + answ + "}");
		
		for (EBoolean b : EBoolean.values()) {
			if (answ.toLowerCase().equals(b.bool()))
				return true;
		}
		
		return false;
	}

	public boolean isCorrectAnswer(String answ) {
		
		return this.answer.equals(answ.toLowerCase());
	}

	public String getCorrectAnswer() {

		return this.answer + "";
	}

	public String getType() {
		return "oui/non";
	}
	
	public String getRealType() {
		return "boolean";
	}

}
