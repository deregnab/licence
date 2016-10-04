package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;

/**
 * Abstract class for all Items in the Game
 *
 * @author seysn
 */
public abstract class Item {

    public Item() {
    }

    /**
     * Does an effect on the Player p
     *
     * @param p Player
     */
    public abstract void isUsedBy(Player p);

    @Override
    public String toString() {
        return super.toString();
    }
}
