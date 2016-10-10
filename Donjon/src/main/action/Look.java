package main.action;

import java.util.List;

import main.item.Item;
import main.personnage.Monster;
import main.personnage.Player;
import main.room.Direction;


public class Look extends Action {

    public Look() {
        super("Look");
    }

    @Override
    public void execute(Player p) {
        List<Monster> monsters = p.getCurrentRoom().getMonsters();
        List<Item> items = p.getCurrentRoom().getItems();
        List<Direction> rooms = p.getCurrentRoom().getNeighborDirections();

        System.out.println("\nYou are currently in the room \""
                + p.getCurrentRoom() + "\"");

        if (!monsters.isEmpty()) {
            System.out.println(monsters.size() + " monster(s) :");
            for (Monster m : monsters) {
                System.out.println("- " + m);
            }
        }

        if (!items.isEmpty()) {
            System.out.println(items.size() + " item(s) :");
            for (Item i : items) {
                System.out.println("- " + i);
            }
        }

        if (!rooms.isEmpty()) {
            System.out.println(rooms.size() + " room(s) around you :");
            for (Direction d : rooms) {
                System.out.println("- " + d + " "
                        + p.getCurrentRoom().getNeighbor(d));
            }
        }
    }
}
