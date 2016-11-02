package fil.coo.action.forseeable;

import fil.coo.action.Action;
import fil.coo.exception.ActionFinishedException;

public class ForeseeableAction extends Action{
	protected int nbStepsMax;
	protected int nbCurrentStep;
	
	/**
	 * @return the number of steps
 	 */
	public int getNbStepsMax(){
		return this.nbStepsMax;
	}
	
	/**
	 * 
	 * @return the current steps
	 */
	public int getCurrentStep(){
		return this.nbCurrentStep;
	}
	
	/**
	 * 
	 * @param nbStepsMax
	 */
	public ForeseeableAction(int nbStepsMax){
		super(nbStepsMax);
		this.nbStepsMax = nbStepsMax;
	}

	public void doStep() throws ActionFinishedException	{
		super.doStep();
        this.nbCurrentStep++;
	}

	/**
	 * create an forseable action
	 */
	public ForeseeableAction createAction()
	{
		return this;
	}
}
