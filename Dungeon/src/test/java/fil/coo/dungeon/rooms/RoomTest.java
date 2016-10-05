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
import org.junit.Test;

/**
 *
 * @author boinc
 */
public class RoomTest {

    protected Room r;
    protected Monster m1, m2;
    protected List<Item> items;

    @Before
    public void setUp() {
        this.r = new Room("Room");
        this.m1 = new Monster("foo", 42, 42, 42, r);
        this.m2 = new Monster("bar", 42, 42, 42, r);
        this.items = new ArrayList<>();
        this.items.add(new GoldPurse(100));
        this.items.add(new HealthPotion(55));
    }

    /**
     * Test of getMonsters method, of class Room.
     */
    @Test
    public void testGetMonsters() {
        System.out.println("getMonsters");
        this.r.addMonsters(this.m1);
        this.r.addMonsters(this.m2);
        assertTrue(this.r.getMonsters().contains(this.m1));
        assertTrue(this.r.getMonsters().contains(this.m2));
    }

    /**
     * Test of getItems method, of class Room.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        this.r.addItems(this.items.get(0));
        this.r.addItems(this.items.get(1));
        assertTrue(this.r.getItems().contains(this.items.get(0)));
        assertTrue(this.r.getItems().contains(this.items.get(1)));
    }

    /**
     * Test of getNeighbor method, of class Room.
     */
    @Test
    public void testGetNeighbor() {
        System.out.println("getNeighbor");
        Room north = new Room("North");
        Room south = new Room("South");
        this.r.addNeighbors(Direction.NORTH, north);
        this.r.addNeighbors(Direction.SOUTH, south);
        assertEquals(north, this.r.getNeighbor(Direction.NORTH));
        assertEquals(south, this.r.getNeighbor(Direction.SOUTH));
    }

    /**
     * Test of getNeighborDirections method, of class Room.
     */
    @Test
    public void testGetNeighborDirections() {
        System.out.println("getNeighborDirections");
        Room west = new Room("West");
        Room east = new Room("East");
        this.r.addNeighbors(Direction.WEST, west);
        this.r.addNeighbors(Direction.EAST, east);

        assertTrue(this.r.getNeighborDirections().contains(Direction.WEST));
        assertTrue(this.r.getNeighborDirections().contains(Direction.EAST));
    }

    /**
     * Test of getName method, of class Room.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String name = "Room";
        assertEquals(name, this.r.getName());
    }

    /**
     * Test of addMonsters method, of class Room.
     */
    @Test
    public void testAddMonsters() {
        System.out.println("addMonsters");
        Monster m = new Monster("foobar", 42, 42, 42, r);
        this.r.addMonsters(m);
        assertTrue(this.r.getMonsters().contains(m));
    }

    /**
     * Test of removeMonster method, of class Room.
     */
    @Test
    public void testRemoveMonster() {
        System.out.println("removeMonster");
        Monster m = new Monster("bar", 42, 42, 42, r);
        this.r.addMonsters(m);
        assertEquals(1, this.r.getMonsters().size());
        this.r.removeMonster(m);
        assertEquals(0, this.r.getMonsters().size());
    }

    /**
     * Test of addItems method, of class Room.
     */
    @Test
    public void testAddItems() {
        System.out.println("addItems");
        this.r.addItems(new GoldPurse(100));
        assertEquals(1, this.r.getItems().size());
    }

    /**
     * Test of addNeighbors method, of class Room.
     */
    @Test
    public void testAddNeighbors() {
        System.out.println("addNeighbors");
        this.r.addNeighbors(Direction.NORTH, this.r);
        this.r.addNeighbors(Direction.EAST, this.r);
        this.r.addNeighbors(Direction.WEST, this.r);
        this.r.addNeighbors(Direction.SOUTH, this.r);
        assertEquals(4, this.r.getNeighborDirections().size());
    }

    /**
     * Test of isExit method, of class Room.
     */
    @Test
    public void testIsExit() {
        System.out.println("isExit");
        assertFalse(this.r.isExit());
    }

    /**
     * Test of removeItem method, of class Room.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item i = new HealthPotion(200);
        this.r.addItems(i);
        assertEquals(1, this.r.getItems().size());
        this.r.removeItem(i);
        assertEquals(0, this.r.getItems().size());
    }

    /**
     * Test of toString method, of class Room.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        this.r.addItems(new GoldPurse(100));
        String expected = "Room";
        assertEquals(expected, this.r.toString());
    }
}
