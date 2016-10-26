package fil.coo.action;

import java.util.NoSuchElementException;

import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;

public class TakeResourceAction<R extends Resource> extends ResourceAction {
	private ResourcePool<R> pool;
	private ResourceUser<R> user;
	private boolean hasStarted;
	
	/**
	 * @param poolToUse The pool of resource to use.
	 * @param aUser The user who will store the resource.
	 */
	public TakeResourceAction(ResourcePool<R> poolToUse, ResourceUser<R> aUser)
	{
		this.pool=poolToUse;
		this.user = aUser;
		
		hasStarted = false;
	}

	@Override
	public boolean isReady() {
		if(!hasStarted && !isFinished())
    		return true;
    	else
    		return false;
	}

	@Override
	public boolean isInProgress() {
		if(!isFinished() && !isReady())
			return true;
		else
			return false;
	}

	@Override
	public boolean isFinished() {
		if(user.getResource()==null)
		{
			return false;
		}
			
		else
		{
			return true;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		
		hasStarted = true;
		
		System.out.print("trying to take resource from pool ... ");
		if(!isFinished())
		{
			try {
				user.setResource(pool.provideResource());
				System.out.println("success");
			} catch(NoSuchElementException e) {
				System.out.println("failed");
			}
			
		}
		else
			throw new ActionFinishedException();
		
	}

}