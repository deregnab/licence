package fil.coo;

import fil.coo.item.Gold;
import fil.coo.item.HealthPotion;
import fil.coo.item.OneArmedBandit;
import fil.coo.item.StrengthPotion;
import fil.coo.menu.Menu;
import fil.coo.menu.MenuAbout;
import fil.coo.personnage.Monster;
import fil.coo.personnage.Player;
import fil.coo.room.Direction;
import fil.coo.room.Exit;
import fil.coo.room.Room;


/**
 *
 * @author deregnaucourt
 */
public class AdventureGame {

    public static void main(String[] args) {
        /* Show menu. */
        Menu menu = new Menu();

        do {
            menu.show();

            if (menu.getChoice() == 2) {
                new MenuAbout().display();
            }

        } while (menu.getChoice() == 2);

        /* Create rooms. */
        Room r1 = new Room("Room 1");
        Room r2 = new Room("Room 2");
        Room r3 = new Room("Room 3");
        Room r4 = new Room("Room 4");
        Exit r5 = new Exit("Room 5");

        /* Add neighbors. */
        r1.addNeighbors(Direction.EAST, r2);
        r2.addNeighbors(Direction.SOUTH, r3);
        r3.addNeighbors(Direction.EAST, r4);
        r4.addNeighbors(Direction.NORTH, r5);
        /* Initializing Rooms contents. */
        Player p = new Player("Hero", 10, 100, 0, r1);

        r2.addItems(new HealthPotion(25));
        r2.addItems(new Gold(45));
        r2.addItems(new StrengthPotion(10));
        r3.addItems(new OneArmedBandit(20,5,10));
        
        r2.addMonsters(new Monster("Kid",10,10,10,r2));
        r3.addMonsters(new Monster("Slime", 30, 20, 12, r3));
        r4.addMonsters(new Monster("Goblin", 25, 35, 192, r4));
        r5.addMonsters(new Monster("Hobgoblin", 35, 40, 200, r5));

        /* Start game. */
        System.out.println("\nStarting Dungeon Game");
        while (!p.isDead() && !p.getCurrentRoom().isExit()) {
            System.out.println("\n" + p);
            p.act();
        }

        /* End of game. */
        if (p.isDead()) {
            System.out.println("Game Over");
        } else {
            System.out.println("You win !");
        }
    }
}
