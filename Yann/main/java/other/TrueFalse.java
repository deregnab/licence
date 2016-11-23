package other;

/**
 * This enum represents the different choices of a BooleanAnswer : oui (true) and non (false)
 * @author Yann GARBE - Thomas HOUSET
 *
 */
public enum TrueFalse {
	oui("true"),
	non("false");
	
		   
	private String name = "";
	
	TrueFalse(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	
}


