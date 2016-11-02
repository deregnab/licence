package fil.coo.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import fil.coo.action.Action;
import fil.coo.exception.ActionFinishedException;

public class FairScheduler extends Scheduler{
	protected int actionNb;
	
	public FairScheduler()
	{
		this.actions = new ArrayList<Action>();
		this.actionNb = 0;
	}
	
	@Override
	public void doStep() throws ActionFinishedException
	{
		Action nextAction = null;
		if (actionNb == this.actions.size())
		{
			nextAction = this.actions.get(0);
			actionNb = 0;
		}
		else
			nextAction = this.actions.get(actionNb);
		nextAction.doStep();
		if (nextAction.isFinished())
		{
			this.getActions().remove(actions.indexOf(nextAction));
			actionNb--;
		}
		actionNb++;
	}
}

