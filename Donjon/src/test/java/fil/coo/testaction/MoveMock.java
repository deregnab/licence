package fil.coo.testaction;

import fil.coo.action.Move;
import fil.coo.personnage.Player;
import fil.coo.room.Direction;

/**
 *
 * @author moulard
 */
public class MoveMock extends Move {

    @Override
    public void execute(Player p) {
        Direction d = p.getCurrentRoom().getNeighborDirections().get(0);
        p.changeCurrentRoom(p.getCurrentRoom().getNeighbor(d));
    }
}
