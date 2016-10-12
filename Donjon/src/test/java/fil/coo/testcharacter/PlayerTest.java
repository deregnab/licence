package fil.coo.testcharacter;

import org.junit.Before;

import fil.coo.personnage.GameCharacter;
import fil.coo.personnage.Monster;
import fil.coo.personnage.Player;

import static org.junit.Assert.*;

/**
 *
 * @author moulard
 */
public class PlayerTest extends GameCharacterTest {

    @Before
    @Override
    public void setUp() {
        super.gc = new Player("TestP", 10, 100, 50, null);
    }

    @Override
    public void testGetName() {
        System.out.println("getName");
        String except = "TestP";
        String result = this.gc.getName();
        assertEquals(except, result);
    }

    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Player TestP hp: 100, strength: 10, gold: 50";
        String result = this.gc.toString();
        assertEquals(except, result);
    }

    @Override
    protected GameCharacter generateEnemy() {
        return new Monster("TestM", 10, 100, 50, null);
    }
}
