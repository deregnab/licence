package fil.coo.dungeon.character;

import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author boinc
 */
public class PlayerTest extends GameCharacterTest {

    @Before
    @Override
    public void setUp() {
        super.gc = new Player("Rick", 10, 100, 50, null);
    }

    @Override
    public void testGetName() {
        System.out.println("getName");
        String except = "Rick";
        String result = gc.getName();
        assertEquals(except, result);
    }

    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Player Rick hp: 100, strength: 10, gold: 50";
        String result = gc.toString();
        assertEquals(except, result);
    }

    @Override
    protected GameCharacter generateEnemy() {
        return new Monster("Jean", 10, 100, 50, null);
    }
}
