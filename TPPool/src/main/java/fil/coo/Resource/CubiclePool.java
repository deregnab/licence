package fil.coo.Resource;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cubicle createResource() {
		// TODO Auto-generated method stub
		return new Cubicle();
	}

}
