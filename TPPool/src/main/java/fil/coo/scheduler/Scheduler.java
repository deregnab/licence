package fil.coo.scheduler;

import java.util.ArrayList;
import java.util.List;

import fil.coo.action.Action;

public abstract class Scheduler extends Action {

    protected List<Action> actions;
    protected boolean hasStarted;
    
    public Scheduler() {
    
        actions = new ArrayList<Action>();
        hasStarted = false;
    
    }
    
    
    public Scheduler(List<Action> actions) {
    
        this.actions = actions;
        hasStarted = false;
    
    }
    
    /**
     * @return the list of Action
     */
    public List<Action> getActions() {
    
        return actions;
    
    }
    
    /**
     * @param index the number of the step
     * @return the action at index value of the list
     */
    public Action getAction(int index) {
    	return getActions().get(index);
    }
    
  
    /**
     * Add an action to the list
     * @param a action to add to the list
     */
    public void addAction(Action a) {
    
        actions.add(a);
    
    }
    /**
     * return true if the scheduler is ready
     * @return
     */
    public boolean isReady() {
    	
    	if(!isInProgress() && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    /**
     * return true if the scheduler is in progress
     */
    public boolean isInProgress() {
    	
    	if(this.hasStarted && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    /**
     * return true if the scheduler is finished
     */
    public boolean isFinished() {
    
        return actions.isEmpty();
    
    }

}