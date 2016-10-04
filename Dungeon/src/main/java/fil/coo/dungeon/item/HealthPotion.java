package fil.coo.dungeon.item;

import fil.coo.dungeon.character.Player;

/**
 * Health Potion is an Item that can be used by the Player to increase his
 * health
 *
 * @author seysn
 */
public class HealthPotion extends Item {

    private final int health;

    public HealthPotion(int health) {
        this.health = health;
    }

    /**
     * Add health to the Player
     *
     * @param p Player
     */
    @Override
    public void isUsedBy(Player p) {
        p.setHealth(p.getHealth() + this.health);
    }

    @Override
    public String toString() {
        return "Health Potion : " + this.health + " health.";
    }
}
