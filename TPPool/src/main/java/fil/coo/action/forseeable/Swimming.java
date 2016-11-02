package fil.coo.action.forseeable;

import fil.coo.exception.ActionFinishedException;

public class Swimming extends ForeseeableAction {

	public Swimming(int swim) {
		super(swim);
	}

	public void doStep() throws ActionFinishedException	{
		super.doStep();
		System.out.println(" swim (" + this.getCurrentStep() + "/" + super.getNbStepsMax() + ")");
	}
}

