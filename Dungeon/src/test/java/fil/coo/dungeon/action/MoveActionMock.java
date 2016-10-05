package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.rooms.Direction;

/**
 *
 * @author boinc
 */
public class MoveActionMock extends MoveAction {

    @Override
    public void execute(Player p) {
        Direction d = p.getCurrentRoom().getNeighborDirections().get(0);
        p.changeCurrentRoom(p.getCurrentRoom().getNeighbor(d));
    }
}
