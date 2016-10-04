package fil.coo.dungeon.character;

import fil.coo.dungeon.action.Action;
import fil.coo.dungeon.action.AttackAction;
import fil.coo.dungeon.action.LookAction;
import fil.coo.dungeon.action.MoveAction;
import fil.coo.dungeon.action.UseAction;
import fil.coo.dungeon.menu.MenuAction;
import fil.coo.dungeon.rooms.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author boin
 */
public class Player extends GameCharacter {

    private Map<String, Action> actions;

    public Player(String name, int strength, int health, int gold, Room currentRoom) {
        super(name, strength, health, gold, currentRoom);
        actions = new HashMap<>();
        this.addAction(new AttackAction());
        this.addAction(new MoveAction());
        this.addAction(new UseAction());
        this.addAction(new LookAction());
    }

    /**
     * Add an new action the current action list.
     *
     * @param action
     */
    public void addAction(Action action) {
        actions.put(action.toString(), action);
    }

    /**
     * Return specified action.
     *
     * @param action
     * @return the action
     */
    public Action getAction(String action) {
        return actions.get(action);
    }

    private List<Action> possibleActions() {
        List<Action> l = new ArrayList<>();

        for (Action a : actions.values()) {
            if (a.isPossible(this)) {
                l.add(a);
            }
        }
        return l;
    }

    /**
     * Do an action.
     */
    public void act() {
        Action a = MenuAction.choice(this.possibleActions());
        a.execute(this);
    }

    @Override
    public String toString() {
        return "Player " + super.toString();
    }
}
