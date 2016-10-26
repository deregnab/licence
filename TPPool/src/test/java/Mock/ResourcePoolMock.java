package Mock;

import fil.coo.Resource.ResourcePool;

public class ResourcePoolMock extends ResourcePool<ResourceMock> {

	public ResourcePoolMock(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceMock createResource() {
		// TODO Auto-generated method stub
		return new ResourceMock();
	}

}
