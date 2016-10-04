package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by GoldPurse.
 *
 * @author boinc
 */
public class GoldPurseTest extends ItemTest {

    private Player p;
    private GoldPurse gp;

    @Before
    public void setUp() {
        p = new Player("Rick", 100, 100, 0, null);
        gp = new GoldPurse(1000);
    }

    /**
     * Test of isUsedBy method, of class GoldPurse.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        gp.isUsedBy(p);
        int except = 1000;
        int result = p.getGold();
        assertEquals(result, except);
    }

    /**
     * Test of toString method, of class GoldPurse.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Gold Purse : 1000 gold.";
        String result = gp.toString();
        assertEquals(except, result);
    }

}
