package fil.coo.testcharacter;

import fil.coo.AdventureGame;
import fil.coo.personnage.GameCharacter;
import fil.coo.room.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moulard
 */
public abstract class GameCharacterTest {

    protected GameCharacter gc;
    private AdventureGame ag;

    @Before
    public void setUp() {
        this.ag = new AdventureGame();
    }

    /**
     * Test of getGame method, of class GameCharacter.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        this.gc.setGame(this.ag);
        assertEquals(this.gc.getGame(), this.ag);
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
        this.gc.setStrength(100);
        assertEquals(100, this.gc.getStrength());
    }

    /**
     * Test of getCurrentRoom method, of class GameCharacter.
     */
    @Test
    public void testGetCurrentRoom() {
        System.out.println("getCurrentRoom");
        Room r = new Room("Room");
        this.gc.changeCurrentRoom(r);
        assertEquals(r, this.gc.getCurrentRoom());
    }

    /**
     * Test of changeCurrentRoom method, of class GameCharacter.
     */
    @Test
    public void testChangeCurrentRoom() {
        System.out.println("changeCurrentRoom");
        Room r = new Room("Change");
        this.gc.changeCurrentRoom(r);
        assertEquals(r, this.gc.getCurrentRoom());
    }

    /**
     * Test of getHealth method, of class GameCharacter.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        this.gc.setHealth(10);
        int expResult = 10;
        int result = this.gc.getHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGold method, of class GameCharacter.
     */
    @Test
    public void testGetGold() {
        System.out.println("getGold");
        this.gc.setGold(10);
        int expResult = 10;
        int result = this.gc.getGold();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStrength method, of class GameCharacter.
     */
    @Test
    public void testSetStrength() {
        System.out.println("setStrength");
        int strength = 0;
        this.gc.setStrength(strength);
        assertEquals(strength, this.gc.getStrength());
    }

    /**
     * Test of isDead method, of class GameCharacter.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        this.gc.setHealth(0);
        assertTrue(this.gc.isDead());
        this.gc.setHealth(100);
        assertFalse(this.gc.isDead());
    }

    /**
     * Test of die method, of class GameCharacter.
     */
    @Test
    public void testDie() {
        /* Not implemened. */
    }

    /**
     * Test of attack method, of class GameCharacter.
     */
    @Test
    public void testAttack() {
        GameCharacter enemy = generateEnemy();
        int except = (enemy.getHealth() - this.gc.getStrength());
        this.gc.attack(enemy);
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
