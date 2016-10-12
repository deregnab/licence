package fil.coo.testitem;

import fil.coo.item.Gold;
import fil.coo.personnage.Player;
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
    private Gold g;

    @Before
    public void setUp() {
        this.p = new Player("Test", 100, 100, 0, null);
        this.g = new Gold(200);
    }

    /**
     * Test of isUsedBy method, of class Gold.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        this.g.isUsedBy(this.p);
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
        String result = this.g.toString();
        assertEquals(except, result);
    }

}
