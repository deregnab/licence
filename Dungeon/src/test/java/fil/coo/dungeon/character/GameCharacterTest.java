package fil.coo.dungeon.character;

import fil.coo.dungeon.AdventureGame;
import fil.coo.dungeon.rooms.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boinc
 */
public abstract class GameCharacterTest {

    protected GameCharacter gc;
    private AdventureGame ag;

    @Before
    public void setUp() {
        ag = new AdventureGame();
    }

    /**
     * Test of getGame method, of class GameCharacter.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        gc.setGame(ag);
        assertEquals(gc.getGame(), ag);
    }

    /**
     * Test of getName method, of class GameCharacter.
     */
    @Test
    public abstract void testGetName();

    /**
     * Test of getStrength method, of class GameCharacter.
     */
    @Test
    public void testGetStrength() {
        System.out.println("getStrength");
        gc.setStrength(100);
        assertEquals(100, gc.getStrength());
    }

    /**
     * Test of getCurrentRoom method, of class GameCharacter.
     */
    @Test
    public void testGetCurrentRoom() {
        System.out.println("getCurrentRoom");
        Room r = new Room("Room");
        gc.changeCurrentRoom(r);
        assertEquals(r, gc.getCurrentRoom());
    }

    /**
     * Test of changeCurrentRoom method, of class GameCharacter.
     */
    @Test
    public void testChangeCurrentRoom() {
        System.out.println("changeCurrentRoom");
        Room r = new Room("Change");
        gc.changeCurrentRoom(r);
        assertEquals(r, gc.getCurrentRoom());
    }

    /**
     * Test of getHealth method, of class GameCharacter.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        gc.setHealth(10);
        int expResult = 10;
        int result = gc.getHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGold method, of class GameCharacter.
     */
    @Test
    public void testGetGold() {
        System.out.println("getGold");
        gc.setGold(10);
        int expResult = 10;
        int result = gc.getGold();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStrength method, of class GameCharacter.
     */
    @Test
    public void testSetStrength() {
        System.out.println("setStrength");
        int strength = 0;
        gc.setStrength(strength);
        assertEquals(strength, gc.getStrength());
    }

    /**
     * Test of isDead method, of class GameCharacter.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        gc.setHealth(0);
        assertTrue(gc.isDead());
        gc.setHealth(100);
        assertFalse(gc.isDead());
    }

    /**
     * Test of die method, of class GameCharacter.
     */
    @Test
    public void testDie() {
    }

    /**
     * Test of attack method, of class GameCharacter.
     */
    @Test
    public void testAttack() {
        GameCharacter enemy = generateEnemy();
        int except = (enemy.getHealth() - gc.getStrength());
        gc.attack(enemy);
        int result = enemy.getHealth();
        assertEquals(except, result);
    }

    /**
     * Test of toString method, of class GameCharacter.
     */
    @Test
    public abstract void testToString();

    protected abstract GameCharacter generateEnemy();

}
