package fil.coo.testaction;
import org.junit.Before;
import org.junit.Test;

import Mock.ResourceMock;
import Mock.ResourcePoolMock;

import fil.coo.exception.ActionFinishedException;
import fil.coo.user.ResourceUser;
import static org.junit.Assert.*;

public abstract class ResourceActionTest {

	
	protected ResourceUser<ResourceMock> ru;
	protected ResourcePoolMock rpm;
	protected ResourcePoolMock rpmv;
	
	@Before
	public void createData(){
		ru=new ResourceUser<ResourceMock>();
		rpm= new ResourcePoolMock(1);
		rpmv=new ResourcePoolMock(0);
	}
	
	@Test
	public abstract void isFinishedTest_Should_ReturnTrue();

	@Test
	public abstract void isFinishedTest_Should_ReturnFalse();
	@Test(expected = ActionFinishedException.class )
	public abstract void doStepTest_ShouldRaiseActionFinishedException();

	@Test
	public abstract void isReadyTest_Should_ReturnTrue();
	
	@Test
	public abstract void isReadyTest_Should_ReturnFalse();
	@Test
	public abstract void isInProgressTest_Should_ReturnTrue();
	
	@Test
	public abstract void isInProgressTest_Should_ReturnFalse();
}
