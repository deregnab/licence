package fil.coo.testaction;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Mock.ResourceMock;
import Mock.ResourcePoolMock;
import fil.coo.action.Action;
import fil.coo.action.forseeable.ForeseeableAction;
import fil.coo.exception.ActionFinishedException;

public class ForeseeableActionTest {

	private Action createAction(int nbStepsMax)
	{
		return new ForeseeableAction(nbStepsMax);
	}
	
	@Test
	public void forseeableActionTest() throws ActionFinishedException 
	{
		Action action = createAction(2);
		
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertTrue(action.isInProgress());
		assertFalse(action.isFinished());
		
		action.doStep();
		
		assertFalse(action.isReady());
		assertTrue(action.isFinished());		
	}
}


