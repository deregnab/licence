package fil.coo.dungeon.item;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import fil.coo.dungeon.character.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by HealPotion.
 *
 * @author boinc
 */
public class HealthPotionTest extends ItemTest {

    private Player p;
    private HealthPotion hp;

    @Before
    public void setUp() {
        p = new Player("Rick", 100, 0, 100, null);
        hp = new HealthPotion(100);
    }

    /**
     * Test of isUsedBy method, of class HealthPotion.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        hp.isUsedBy(p);
        int except = 100;
        int result = p.getHealth();
        assertEquals(except, result);
    }

    /**
     * Test of toString method, of class HealthPotion.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Health Potion : 100 health.";
        String result = hp.toString();
        assertEquals(except, result);
    }

}
