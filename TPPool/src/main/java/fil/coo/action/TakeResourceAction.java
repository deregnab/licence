package fil.coo.action;

import java.util.NoSuchElementException;

import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;

public class TakeResourceAction<R extends Resource> extends Action{
    protected ResourcePool<R> pool;
    protected ResourceUser<R> user;
    protected boolean isReady;
    protected boolean isInProgress;
    protected boolean isFinished;
	
    /**
     * define tjhe list of pool and user to take
     * @param pool
     * @param user
     */
	public TakeResourceAction(ResourcePool<R> pool, ResourceUser<R> user){
		this.pool = pool;
		this.user = user;
	}
	
	/**
	 * Return true if the action is ready
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
		System.out.print(" " + this.user.getName() + " trying to take resource from " + this.pool.toString() + "... ");
		try{
			R resource = this.pool.provideResource();
			this.user.setResource(resource);
			this.isReady = false;
			this.isFinished = true;
			System.out.println("success");
          	}catch(NoSuchElementException e){
          		System.out.println("failure");
          	}
	}
	

}
