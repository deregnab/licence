package fil.coo.action;

import java.util.ArrayList;

import fil.coo.exception.ActionFinishedException;

/**
 * this abstract class describes an action which is use to create several action such as a foreseable action
 *
 *
 */
public abstract class Action {

	protected int totalTime = 0;
	protected int remainingTime = 0;
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	protected final ArrayList<Action> actions = new ArrayList<Action>();

	/**
	 * empty constructor in order to allowed the creation of new constructors in extended classes 
	 */
	public Action(){}
	
	
	
	public Action(int timeToEnd) 
	{
		this.totalTime = timeToEnd;
	}
	
	/**
	
	 * @return the action
	 */
	protected  Action createAction(){
		return this;
	}
	
	
	/**
	 * check if an action is finished
	 * @return true/false
	 */
	public boolean isFinished() {
		if (this.totalTime == this.remainingTime)
		{
			this.isInitialized = false;
			return true;
		}
		else
			return false;
		}
	
	
	public void doStep() throws ActionFinishedException {

		if (this.isFinished())
			throw new ActionFinishedException();
		this.remainingTime++;
		if (this.isReady())
			this.isReady = false;
		this.isInitialized = true;
	}
	
	
	boolean isReady() {
		return this.isReady;

	}
	
	/**
	 * return true if the action is not finished
	 * @return true/false
	 */
	public boolean isInProgress() {
		return (!this.isReady() && !this.isFinished() && this.isInitialized);	}
	}

