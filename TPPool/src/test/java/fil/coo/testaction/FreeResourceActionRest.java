package fil.coo.testaction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.exception.ActionFinishedException;

public class FreeResourceActionRest extends ResourceActionTest{

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void isFinishedTest_Should_ReturnTrue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void isFinishedTest_Should_ReturnFalse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test(expected = ActionFinishedException.class)
	public void doStepTest_ShouldRaiseActionFinishedException() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void isReadyTest_Should_ReturnTrue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void isReadyTest_Should_ReturnFalse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void isInProgressTest_Should_ReturnTrue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void isInProgressTest_Should_ReturnFalse() {
		// TODO Auto-generated method stub
		
	}

}
