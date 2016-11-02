package fil.coo.Resource;

public class BasketPool extends ResourcePool<Basket>{

	public BasketPool(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Basket createResource() {
		// TODO Auto-generated method stub
		return new Basket();
	}
	
	/**
	 * return the name of the pool
	 */
	public String toString(){
		
		return ("Basket Pool ");
	}
}
