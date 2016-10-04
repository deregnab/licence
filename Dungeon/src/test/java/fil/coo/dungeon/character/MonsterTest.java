package fil.coo.dungeon.character;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boinc
 */
public class MonsterTest extends GameCharacterTest {

    @Before
    @Override
    public void setUp() {
        super.gc = new Monster("Jean", 100, 100, 100, null);
    }

    /**
     * Test of die method, of class Monster.
     */
    @Test
    @Override
    public void testDie() {
    }

    /**
     * Test of toString method, of class Monster.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Monster Jean hp: 100, strength: 100, gold: 100";
        String result = gc.toString();
        assertEquals(except, result);
    }

    @Override
    public void testGetName() {
        System.out.println("getName");
        String except = "Jean";
        String result = gc.getName();
        assertEquals(except, result);
    }

    @Override
    protected GameCharacter generateEnemy() {
        return new Player("Rick", 10, 100, 50, null);
    }

}
