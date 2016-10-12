package fil.coo.action;

import fil.coo.menu.ActionMenu;
import fil.coo.personnage.Player;
import fil.coo.room.Direction;


/**
 * Extends Action, this class allows the player to change his current Room
 * @author deregnaucourt
 *
 */

public class Move extends Action {


    public Move() {
        super("Move");
    }

    /**
     * Trigger the Move Action on Player p
     *
     * @param p Player
     */
    @Override
    public void execute(Player p) {
        Direction d = ActionMenu.choice(p.getCurrentRoom().getNeighborDirections());
        p.changeCurrentRoom(p.getCurrentRoom().getNeighbor(d));
    }

    /**
     * Verify if the Move Action is possible on the Player p
     *
     * @param p Player
     * @return true if action is possible
     */
    @Override
    public boolean isPossible(Player p) {
        return super.isPossible(p) && p.getCurrentRoom().getMonsters().isEmpty();
    }
}
