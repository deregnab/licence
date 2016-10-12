package fil.coo.testcharacter;

import fil.coo.personnage.GameCharacter;
import fil.coo.personnage.Monster;
import fil.coo.personnage.Player;
import fil.coo.room.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moulard
 */
public class MonsterTest extends GameCharacterTest {
    
    private Room r;

    @Before
    @Override
    public void setUp() {
        this.r = new Room("Room");
        super.gc = new Monster("Test", 100, 100, 100, r);
    }

    /**
     * Test of die method, of class Monster.
     */
    @Test
    @Override
    public void testDie() {
        super.gc.die();
        assertFalse(this.r.getItems().isEmpty());
    }

    /**
     * Test of toString method, of class Monster.
     */
    @Test
    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Monster Test hp: 100, strength: 100, gold: 100";
        String result = super.gc.toString();
        assertEquals(except, result);
    }

    @Override
    public void testGetName() {
        System.out.println("getName");
        String except = "Test";
        String result = super.gc.getName();
        assertEquals(except, result);
    }

    @Override
    protected GameCharacter generateEnemy() {
        return new Player("TestM", 10, 100, 50, null);
    }

}
