package fil.coo.testitem;

import fil.coo.item.StrengthPotion;
import fil.coo.personnage.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by StrengthPotion.
 *
 * @author moulard
 */
public class StrengthPotionTest extends ItemTest {

    private Player p;
    private StrengthPotion sp;

    @Before
    public void setUp() {
        this.p = new Player("Test", 0, 100, 100, null);
        this.sp = new StrengthPotion(200);
    }

    /**
     * Test of isUsedBy method, of class StrengthPotion.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        this.sp.isUsedBy(this.p);
        int except = 200;
        int result = this.p.getStrength();
        assertEquals(except, result);
    }

    /**
     * Test of toString method, of class StrengthPotion.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Strength Potion : 200 strength.";
        String result = this.sp.toString();
        assertEquals(except, result);
    }
}
