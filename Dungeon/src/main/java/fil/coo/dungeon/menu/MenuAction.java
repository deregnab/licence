package fil.coo.dungeon.menu;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author seysn
 */
public class MenuAction {

    public static <T> T choice(List<T> actions) {
        for (T action : actions) {
            System.out.println(actions.indexOf(action) + 1
                    + ": " + action);
        }

        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.print("Your choice: ");
            // TODO : Handle NumberFormatException
            choice = Integer.parseInt(sc.next());
        } while (!isValidChoice(choice, actions.size()));

        return actions.get(choice - 1);
    }

    private static boolean isValidChoice(int choice, int size) {
        return choice > 0 && choice <= size;
    }
}
