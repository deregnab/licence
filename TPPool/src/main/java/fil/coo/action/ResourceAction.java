package fil.coo.action;

import fil.coo.Resource.Resource;
import fil.coo.exception.ActionFinishedException;

public abstract class ResourceAction<R extends Resource> implements Action{
	public abstract boolean isFinished();

	public abstract void doStep() throws ActionFinishedException;

	public abstract boolean isReady();

	public abstract boolean isInProgress();

}
