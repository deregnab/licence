package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test each method provide by StrengthPotion.
 *
 * @author boinc
 */
public class StrengthPotionTest extends ItemTest {

    private Player p;
    private StrengthPotion sp;

    @Before
    public void setUp() {
        this.p = new Player("Bob", 0, 100, 100, null);
        this.sp = new StrengthPotion(100);
    }

    /**
     * Test of isUsedBy method, of class StrengthPotion.
     */
    @Test
    @Override
    public void testIsUsedBy() {
        System.out.println("isUsedBy");
        this.sp.isUsedBy(this.p);
        int except = 100;
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
        String except = "Strength Potion : 100 strength.";
        String result = this.sp.toString();
        assertEquals(except, result);
    }
}
