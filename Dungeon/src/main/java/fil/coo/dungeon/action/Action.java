package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Player;

/**
 * Abstract class for all Actions in the Game
 *
 * @author seysn
 */
public abstract class Action {

    private final String description;

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
