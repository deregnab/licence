package fil.coo.scheduler;

import fil.coo.Resource.Basket;
import fil.coo.Resource.BasketPool;
import fil.coo.Resource.Cubicle;
import fil.coo.Resource.CubiclePool;
import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;
import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;
import fil.coo.action.*;
import fil.coo.action.forseeable.Dressing;
import fil.coo.action.forseeable.Swimming;
import fil.coo.action.forseeable.Undressing;

public class Swimmer extends Action
{
    protected final ResourceUser<Basket> basketUser;
    protected final ResourceUser<Cubicle> cubicleUser;
    protected final SequentialScheduler process;
    protected String name;
    
	public Swimmer(String name, ResourcePool<Basket> baskets, ResourcePool<Cubicle> cubicles, int undress, int swim, int dress)
	{
		super();
		this.name = name;
        this.process = new SequentialScheduler();
        this.basketUser = new ResourceUser<Basket>(name);
        this.cubicleUser = new ResourceUser<Cubicle>(name);

        /*
         * Create all action in order for swimmer
         */
        this.process.addAction(new TakeResourceAction<Basket>(baskets, basketUser));
        this.process.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        this.process.addAction(new Undressing(undress));
        this.process.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        this.process.addAction(new Swimming(swim));
        this.process.addAction(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        this.process.addAction(new Dressing(dress));
        this.process.addAction(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        this.process.addAction(new FreeResourceAction<Basket>(baskets, basketUser));
	}

	public boolean isFinished(){
		return this.process.isFinished();
	}
	
	public void doStep() throws ActionFinishedException{
		System.out.println(this.name + "'s turn");
		this.process.doStep();
	}
}
