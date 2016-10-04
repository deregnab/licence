package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;

/**
 * Strength Potion is an Item that can be used by the Player to increase his
 * strength
 *
 * @author seysn
 */
public class StrengthPotion extends Item {

    private final int strength;

    public StrengthPotion(int strength) {
        this.strength = strength;
    }

    /**
     * Add strength to the Player
     *
     * @param p Player
     */
    @Override
    public void isUsedBy(Player p) {
        p.setStrength(p.getStrength() + this.strength);
    }

    @Override
    public String toString() {
        return "Strength Potion : " + this.strength + " strength.";
    }
}
