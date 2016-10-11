package fil.coo.action;
import fil.coo.personnage.Player;
/**
 * Abstract class for all Actions in the Game
 *
 * @author deregnaucourt
 */
public abstract class Action {
    private String description;
    public Action(String description) {
        this.description = description;
    }
    /**
     * Execute an action on the Player p
     *
     * @param p Player
     */
    public abstract void execute(Player p);
    /**
     * Verify if the Action is possible on the Player p
     *
     * @param p Player
     * @return b boolean
     */
    public boolean isPossible(Player p) {
        return !p.isDead();
    }
    @Override
    public String toString() {
        return this.description;
    }
}