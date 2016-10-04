package fil.coo.dungeon.rooms;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author boinc
 */
public class ExitTest extends RoomTest {

    private Exit e;

    @Before
    @Override
    public void setUp() {
        e = new Exit("Exit");
    }

    /**
     * Test of isExit method, of class Exit.
     */
    @Test
    @Override
    public void testIsExit() {
        System.out.println("isExit");
        assertTrue(e.isExit());
    }

}
