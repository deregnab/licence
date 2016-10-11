package test.java.fil.coo.dungeon.action;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moulard
 */
public class UseTest extends ActionTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        super.a = new Use();
    }

    /**
     * Test of execute method, of class Use.
     */
    @Test
    @Override
    public void testExecute() {
        System.out.println("execute");
        new UseMock().execute(super.p);
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
