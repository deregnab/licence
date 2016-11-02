package fil.coo.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *   Abstract Class for all Resource Pool	
 */
public abstract class ResourcePool<R extends Resource>{
	private List<R> pool;
	private List<R> used;

	protected abstract R createResource();

	/**
	 * Create pool and user for resource
	 */
	public ResourcePool(int nb)	{
		this.pool = new ArrayList<R>(nb);
		this.used = new ArrayList<R>(nb);
		for (int i = 0 ; i < nb ; i++)	{
			pool.add(this.createResource());
		}
	}

	/**
	 * return first resource
	 */
	public R provideResource()	{
		if (!pool.isEmpty()){
			R Resource = pool.get(0);
			pool.remove(0);
			used.add(Resource);
			return Resource;
		}
		throw new NoSuchElementException();
	}

	/**
	 * free the Resource in param
	 * @param r Resource of the ResourcePool
	 */
	public void freeResource(R r){
		if (used.remove(r))
			pool.add(r);
		else
			throw new IllegalArgumentException();
	}

}
