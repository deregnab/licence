package fil.coo.action;

import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction{
	private ResourcePool<R> pool;
	private ResourceUser<R> user;
	private boolean hasStarted;
	
	/**
	 * @param poolToUse the pool taking the resource.
	 * @param aUser the user that will release the resource.
	 */
	public FreeResourceAction(ResourcePool<R> poolToUse, ResourceUser<R> aUser)
	{
		this.pool=poolToUse;
		this.user=aUser;
		
		hasStarted = false;
	}

	@Override
	public boolean isReady() {
		if(!isInProgress() && !isFinished())
			return true;
		else
			return false;
	}

	@Override
	public boolean isInProgress() {
		return (hasStarted && !isFinished());
	}

	@Override
	public boolean isFinished() {
		if(user.getResource()!=null)
		{
			System.out.println("Resource is not free");
			return false;
		}
		else
		{
			System.out.println("freeing resource from pool ");
			return true;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		
		hasStarted = true;
		
		if(!isFinished())
		{
			pool.freeResource(user.getResource());
			user.resetResource();
		}
		else
			throw new ActionFinishedException();
	}

}