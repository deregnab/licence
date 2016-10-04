package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Monster;
import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.item.Item;
import fil.coo.dungeon.rooms.Direction;
import java.util.List;

/**
 *
 * @author seysn
 */
public class LookAction extends Action {

    public LookAction() {
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
