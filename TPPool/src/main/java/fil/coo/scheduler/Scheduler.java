package fil.coo.scheduler;

import java.util.ArrayList;
import java.util.List;

import fil.coo.action.Action;

public abstract class Scheduler implements Action {

    protected List<Action> actions;
    protected boolean hasStarted;
    
    public Scheduler() {
    
        actions = new ArrayList<Action>();
        hasStarted = false;
    
    }
    
    public Scheduler(List<Action> actions2) {
    
        this.actions = actions2;
        hasStarted = false;
    
    }
    
    
    public List<Action> getActions() {
    
        return actions;
    
    }
    
    public Action getAction(int index) {
    	return getActions().get(index);
    }
    
  
    public void addAction(Action a) {
    
        actions.add(a);
    
    }
    
    public boolean isReady() {
    	
    	if(!isInProgress() && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    public boolean isInProgress() {
    	
    	if(this.hasStarted && !isFinished())
    		return true;
    	else
    		return false;
    	
    }
    
    public boolean isFinished() {
    
        return actions.isEmpty();
    
    }

}