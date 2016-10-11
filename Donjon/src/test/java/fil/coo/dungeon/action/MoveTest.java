package test.java.fil.coo.dungeon.action;

import org.junit.Before;
import org.junit.Test;

import main.action.Move;

import static org.junit.Assert.*;

/**
 *
 * @author moulard
 */
public class MoveTest extends ActionTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        super.a = new Move();
    }

    /**
     * Test of execute method, of class Move.
     */
    @Test
    @Override
    public void testExecute() {
        System.out.println("execute");
        new MoveMock().execute(super.p);
        assertEquals(super.p.getCurrentRoom().getName(), "EAST");
    }

    /**
     * Test of isPossible method, of class Move.
     */
    @Test
    @Override
    public void testIsPossible() {
        System.out.println("isPossible");
        boolean expResult = false;
        boolean result = this.a.isPossible(this.p);
        assertEquals(expResult, result);
    }

    @Override
    public void testToString() {
        System.out.println("toString");
        String except = "Move";
        String result = this.a.toString();
        assertEquals(except, result);
    }

}
