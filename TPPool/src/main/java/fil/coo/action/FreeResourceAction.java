package fil.coo.action;

import java.util.NoSuchElementException;
import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;

public class FreeResourceAction<R extends Resource> extends Action{
    protected ResourcePool<R> pool;
    protected ResourceUser<R> user;
    protected boolean isReady;
    protected boolean isInProgress;
    protected boolean isFinished;
	
    
    /**
     * assign a User and a Pool to the action
     * @param pool
     * @param user
     */
	public FreeResourceAction(ResourcePool<R> pool, ResourceUser<R> user){
		this.pool = pool;
		this.user = user;
	}

	/**
	 * return true  if the action is ready
	 */
	@Override
	public boolean isReady() {
		return this.isReady;
	}

	/**
	 * return true if the action is in progress
	 */
	@Override
	public boolean isInProgress() {
		return this.isInProgress;
	}

	/**
	 * return true if the action is finished
	 */
	@Override
	public boolean isFinished() {
		return this.isFinished;
	}
	
	@Override
	public void doStep() throws ActionFinishedException {
		System.out.println(" " + this.user.getName() + " free " + this.pool.toString() + "... ");
		R resource = this.user.getResource();
		try{
			this.pool.freeResource(resource);
			this.isReady = false;
			this.isFinished = true;
          	}catch(NoSuchElementException e){
          		System.out.println("bug");
          	}
	}

}
