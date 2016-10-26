package fil.coo.action;

import fil.coo.exception.ActionFinishedException;

public interface Action {

	boolean isFinished();
	void doStep() throws ActionFinishedException;
	boolean isReady();
	public boolean isInProgress();
}

