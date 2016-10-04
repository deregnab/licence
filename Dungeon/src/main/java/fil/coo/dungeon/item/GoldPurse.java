package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;

/**
 * Gold Purse is an Item that can be used by the Player to increase his gold
 *
 * @author seysn
 */
public class GoldPurse extends Item {

    private final int gold;

    public GoldPurse(int gold) {
        this.gold = gold;
    }

    /**
     * Add gold to the Player
     *
     * @param p Player
     */
    @Override
    public void isUsedBy(Player p) {
        p.setGold(p.getGold() + this.gold);
    }

    @Override
    public String toString() {
        return "Gold Purse : " + this.gold + " gold.";
    }
}
