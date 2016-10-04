package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.menu.MenuAction;
import fil.coo.dungeon.rooms.Direction;

/**
 * MoveAction is an Action that can executed by the Player to move in another
 * Room
 *
 * @author seysn
 */
public class MoveAction extends Action {

    public MoveAction() {
        super("Move");
    }

    /**
     * Trigger the Move Action on Player p
     *
     * @param p Player
     */
    @Override
    public void execute(Player p) {
        Direction d = MenuAction.choice(p.getCurrentRoom().getNeighborDirections());
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
