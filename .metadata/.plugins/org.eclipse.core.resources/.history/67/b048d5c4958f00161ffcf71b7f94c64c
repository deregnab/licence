package fil.coo.dungeon.action;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boinc
 */
public class UseActionTest extends ActionTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        super.a = new UseAction();
    }

    /**
     * Test of execute method, of class UseAction.
     */
    @Test
    @Override
    public void testExecute() {
        System.out.println("execute");
        new UseActionMock().execute(super.p);
        assertEquals(super.r.getItems().size(), 2);
    }

    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Use Item";
        String result = this.a.toString();
        assertEquals(except, result);
    }

}
