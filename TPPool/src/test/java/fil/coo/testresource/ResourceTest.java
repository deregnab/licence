package fil.coo.testresource;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import fil.coo.Resource.Basket;
import fil.coo.Resource.BasketPool;
import fil.coo.Resource.Resource;
import fil.coo.Resource.ResourcePool;

public class ResourceTest {

	protected ResourcePoolMock rp;
	protected ResourcePoolMock rp2;
	
	@Before
	public void createResourcePool(){
		this.rp=new ResourcePoolMock(1);
		this.rp2=new ResourcePoolMock(0);	
		
	}
	
	@Test 
	public void testProvideResource(){
		
		assertNotNull(rp.provideResource());
	}
	
	@Test
	public void testFreeResource(){
		
		ResourceMock res=rp.provideResource();
		assertTrue(rp.freeResource(res));
	}

	@Test(expected=NoSuchElementException.class)
	public void testExpectedProvideResource(){
		this.rp2.provideResource();
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testExpectedFreeResource(){
		try {
			this.rp.freeResource(rp.createResource());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

