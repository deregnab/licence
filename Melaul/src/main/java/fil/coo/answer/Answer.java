package fil.coo.answer;

/**
 * Generic class implementing the IAnswer interface, with the purpose of guiding
 * the specific subclass depending of their type.
 * 
 * @author dambrine
 *
 * @param <T>
 */
public abstract class Answer<T> implements IAnswer {

	/**
	 * The answer
	 */
	protected String answer;
	
	public Answer(String answer) {
		this.answer = answer;
	}
}
