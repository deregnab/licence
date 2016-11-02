package fil.coo.scheduler;

import java.util.List;
import java.util.NoSuchElementException;

import fil.coo.action.Action;
import fil.coo.exception.ActionFinishedException;

public class FairScheduler extends Scheduler {

	int currentAction;

	public FairScheduler() {
		super();
		currentAction = 0;
	}

	public FairScheduler(List<Action> actions) {
		super(actions);
		currentAction = 0;
	}

	public void addAction(Swimmer swimmer) {
		// TODO Auto-generated method stub

	}

	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public void doStep() throws ActionFinishedException {

		hasStarted = true;

		if (this.currentAction >= this.actions.size()) {

			this.currentAction = 0;
		}

		if (!this.getAction(currentAction).isFinished()) {

			try {

				this.getActions().get(this.currentAction).doStep();

				if (this.getActions().get(this.currentAction).isFinished()) {

					this.getActions().remove(this.currentAction);
					currentAction--;

				}

			} catch (NoSuchElementException e) {

				System.out.println("Taking resource failed!");

			}

		}
		currentAction++;
	}

}
