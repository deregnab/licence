package fil.coo.action.forseeable;

import fil.coo.action.Action;
import fil.coo.exception.ActionFinishedException;

public class Undressing extends ForeseeableAction{
	public Undressing(int undress) {
		super(undress);
	}

	public void doStep() throws ActionFinishedException
	{
		super.doStep();
		System.out.println(" Undressing (" + this.getCurrentStep() + "/" + super.getNbStepsMax() + ")");
	}
}
