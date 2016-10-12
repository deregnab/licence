package fil.coo.item;

import fil.coo.personnage.*;
/**
 * Abstract class for all Items in the Game
 *
 * @author deregnaucourt
 */
public abstract class Item {
    public Item() {
    }
    /**
     * Does an effect on the Player p
     *
     * @param p Player
     */
    public abstract int isUsedBy(Player p);
    @Override
    public String toString() {
        return super.toString();
    }
}