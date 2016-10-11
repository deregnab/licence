package main.personnage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;


import main.action.Action;
import main.action.Attack;
import main.action.Look;
import main.action.Move;
import main.action.Use;
import main.menu.ActionMenu;
import main.room.Room;
/**
 *
 * @author moulard
 */
public class Player extends GameCharacter {
    
    private final Map<String, Action> actions;

    public Player(String name, int strength, int health, int gold, Room currentRoom) {
        super(name, strength, health, gold, currentRoom);
        actions = new HashMap<>();
        this.addAction(new Attack());
        this.addAction(new Move());
        this.addAction(new Use());
        this.addAction(new Look());
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
        Action a = ActionMenu.choice(this.possibleActions());
        a.execute(this);
    }

    @Override
    public String toString() {
        return "Player " + super.toString();
    }

    @Override
    public void die() {
        /* Here die cause game over. */
    }
}
