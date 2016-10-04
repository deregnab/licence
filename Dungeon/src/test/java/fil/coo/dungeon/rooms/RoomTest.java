/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fil.coo.dungeon.rooms;

import fil.coo.dungeon.character.Monster;
import fil.coo.dungeon.item.GoldPurse;
import fil.coo.dungeon.item.HealthPotion;
import fil.coo.dungeon.item.Item;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author boinc
 */
public class RoomTest {

    private Room r;
    private Monster m1, m2;
    private List<Item> items;

    @Before
    public void setUp() {
        r = new Room("Room");
        m1 = new Monster("foo", 42, 42, 42, r);
        m2 = new Monster("bar", 42, 42, 42, r);
        items = new ArrayList<>();
        items.add(new GoldPurse(100));
        items.add(new HealthPotion(55));
    }

    /**
     * Test of getMonsters method, of class Room.
     */
    @org.junit.Test
    public void testGetMonsters() {
        System.out.println("getMonsters");
        r.addMonsters(m1);
        r.addMonsters(m2);
        assertTrue(r.getMonsters().contains(m1));
        assertTrue(r.getMonsters().contains(m2));
    }

    /**
     * Test of getItems method, of class Room.
     */
    @org.junit.Test
    public void testGetItems() {
        System.out.println("getItems");

        r.addItems(items.get(0));
        r.addItems(items.get(1));

        assertTrue(r.getItems().contains(items.get(0)));
        assertTrue(r.getItems().contains(items.get(1)));
    }

    /**
     * Test of getNeighbor method, of class Room.
     */
    @org.junit.Test
    public void testGetNeighbor() {
        System.out.println("getNeighbor");
        Room north = new Room("North");
        Room south = new Room("South");
        r.addNeighbors(Direction.NORTH, north);
        r.addNeighbors(Direction.SOUTH, south);

        assertEquals(north, r.getNeighbor(Direction.NORTH));
        assertEquals(south, r.getNeighbor(Direction.SOUTH));
    }

    /**
     * Test of getNeighborDirections method, of class Room.
     */
    @org.junit.Test
    public void testGetNeighborDirections() {
        System.out.println("getNeighborDirections");
        Room west = new Room("West");
        Room east = new Room("East");

        r.addNeighbors(Direction.WEST, west);
        r.addNeighbors(Direction.EAST, east);

        assertTrue(r.getNeighborDirections().contains(Direction.WEST));
        assertTrue(r.getNeighborDirections().contains(Direction.EAST));
    }

    /**
     * Test of getName method, of class Room.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        String name = "Room";
        assertEquals(name, r.getName());
    }

    /**
     * Test of addMonsters method, of class Room.
     */
    @org.junit.Test
    public void testAddMonsters() {
        System.out.println("addMonsters");
        Monster m = new Monster("foobar", 42, 42, 42, r);
        r.addMonsters(m);
        assertTrue(r.getMonsters().contains(m));
    }

    /**
     * Test of removeMonster method, of class Room.
     */
    @org.junit.Test
    public void testRemoveMonster() {
        System.out.println("removeMonster");
        Monster m = new Monster("bar", 42, 42, 42, r);
        r.addMonsters(m);
        assertEquals(1, r.getMonsters().size());
        r.removeMonster(m);
        assertEquals(0, r.getMonsters().size());
    }

    /**
     * Test of addItems method, of class Room.
     */
    @org.junit.Test
    public void testAddItems() {
        System.out.println("addItems");
        r.addItems(new GoldPurse(100));
        assertEquals(1, r.getItems().size());
    }

    /**
     * Test of addNeighbors method, of class Room.
     */
    @org.junit.Test
    public void testAddNeighbors() {
        System.out.println("addNeighbors");
        r.addNeighbors(Direction.NORTH, r);
        r.addNeighbors(Direction.EAST, r);
        r.addNeighbors(Direction.WEST, r);
        r.addNeighbors(Direction.SOUTH, r);

        assertEquals(4, r.getNeighborDirections().size());
    }

    /**
     * Test of isExit method, of class Room.
     */
    @org.junit.Test
    public void testIsExit() {
        System.out.println("isExit");
        assertFalse(r.isExit());
    }

    /**
     * Test of removeItem method, of class Room.
     */
    @org.junit.Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item i = new HealthPotion(200);

        r.addItems(i);
        assertEquals(1, r.getItems().size());
        r.removeItem(i);
        assertEquals(0, r.getItems().size());
    }

    /**
     * Test of toString method, of class Room.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        r.addItems(new GoldPurse(100));
        String expected = "Room";
        assertEquals(expected, r.toString());

    }

}
