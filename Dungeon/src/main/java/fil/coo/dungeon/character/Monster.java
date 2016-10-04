package fil.coo.dungeon.character;

import fil.coo.dungeon.item.GoldPurse;
import fil.coo.dungeon.rooms.Room;

/**
 *
 * @author boin
 */
public class Monster extends GameCharacter {

    public Monster(String name, int strength, int health, int gold, Room currentRoom) {
        super(name, strength, health, gold, currentRoom);
    }

    /**
     * Kill the monster.
     */
    @Override
    public void die() {
        super.die();
        this.getCurrentRoom().addItems(new GoldPurse(this.getGold()));
        this.getCurrentRoom().removeMonster(this);
    }

    @Override
    public String toString() {
        return "Monster " + super.toString();
    }
}
