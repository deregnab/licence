package fil.coo.testitem;

import fil.coo.item.HealthPotion;
import fil.coo.personnage.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by HealPotion.
 *
 * @author moulard
 */
public class HealthPotionTest extends ItemTest {

    private Player p;
    private HealthPotion hp;

    @Before
    public void setUp() {
        this.p = new Player("Test", 100, 0, 100, null);
        this.hp = new HealthPotion(200);
    }

    /**
     * Test of isUsedBy method, of class HealthPotion.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        this.hp.isUsedBy(this.p);
        int except = 200;
        int result = this.p.getHealth();
        assertEquals(except, result);
    }

    /**
     * Test of toString method, of class HealthPotion.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Health Potion : 200 health.";
        String result = this.hp.toString();
        assertEquals(except, result);
    }

}
