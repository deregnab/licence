package fil.coo.dungeon.rooms;

import fil.coo.dungeon.character.Monster;
import fil.coo.dungeon.item.GoldPurse;
import fil.coo.dungeon.item.HealthPotion;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author boinc
 */
public class ExitTest extends RoomTest {

    @Before
    @Override
    public void setUp() {
        super.r = new Exit("Exit");
        super.m1 = new Monster("foo", 42, 42, 42, r);
        super.m2 = new Monster("bar", 42, 42, 42, r);
        super.items = new ArrayList<>();
        super.items.add(new GoldPurse(100));
        super.items.add(new HealthPotion(55));
    }

    /**
     * Test of isExit method, of class Exit.
     */
    @Test
    @Override
    public void testIsExit() {
        System.out.println("isExit");
        assertTrue(super.r.isExit());
    }

    /**
     * Test of toString method, of class Room.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        super.r.addItems(new GoldPurse(100));
        String expected = "Exit";
        assertEquals(expected, super.r.toString());

    }

    /**
     * Test of getName method, of class Room.
     */
    @Test
    @Override
    public void testGetName() {
        System.out.println("getName");
        String name = "Exit";
        assertEquals(name, super.r.getName());
    }

}
