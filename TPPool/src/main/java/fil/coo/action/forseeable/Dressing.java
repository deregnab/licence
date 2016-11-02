package fil.coo.action.forseeable;

import fil.coo.exception.ActionFinishedException;

public class Dressing extends ForeseeableAction{
		public Dressing(int dress) {
			super(dress);
		}

		public void doStep() throws ActionFinishedException {
			super.doStep();
			System.out.println(" Dressing (" + this.getCurrentStep() + "/" + super.getNbStepsMax() + ")");
		}
	}
