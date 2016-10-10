package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Monster;
import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.item.GoldPurse;
import fil.coo.dungeon.item.HealthPotion;
import fil.coo.dungeon.item.StrengthPotion;
import fil.coo.dungeon.rooms.Direction;
import fil.coo.dungeon.rooms.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boin
 */
public abstract class ActionTest {

    protected Room r;
    protected Player p;
    protected Action a;

    @Before
    public void setUp() {
        this.r = new Room("Room");
        /* Add monsters */
        this.r.addMonsters(new Monster("Rick", 10, 40, 45, this.r));
        this.r.addMonsters(new Monster("Joe", 10, 40, 90, this.r));

        /* Create player */
        this.p = new Player("Andrew", 40, 100, 500, this.r);

        /* Add items */
        this.r.addItems(new GoldPurse(400));
        this.r.addItems(new HealthPotion(50));
        this.r.addItems(new StrengthPotion(20));

        /* Add one neightboor */
        this.r.addNeighbors(Direction.EAST, new Room("EAST"));
    }

    /**
     * Test of execute method, of class Action.
     */
    @Test
    public abstract void testExecute();

    /**
     * Test of isPossible method, of class Action.
     */
    @Test
    public void testIsPossible() {
        System.out.println("isPossible");
        boolean expResult = true;
        boolean result = this.a.isPossible(this.p);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Action.
     */
    @Test
    public abstract void testToString();

}
