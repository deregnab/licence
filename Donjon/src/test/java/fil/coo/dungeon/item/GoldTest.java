package test.java.fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by GoldPurse.
 *
 * @author moulard
 */
public class GoldTest extends ItemTest {

    private Player p;
    private Gold gp;

    @Before
    public void setUp() {
        this.p = new Player("Test", 100, 100, 0, null);
        this.gp = new Gold(200);
    }

    /**
     * Test of isUsedBy method, of class Gold.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        this.gp.isUsedBy(this.p);
        int except = 200;
        int result = this.p.getGold();
        assertEquals(result, except);
    }

    /**
     * Test of toString method, of class Gold.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Gold : 1000 gold.";
        String result = this.gp.toString();
        assertEquals(except, result);
    }

}
