package fil.coo.personnage;
import fil.coo.item.Gold;
import fil.coo.personnage.*;
import fil.coo.room.Room;
/**
 *
 * @author deregnaucourt
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
        this.getCurrentRoom().addItems(new Gold(this.getGold()));
        this.getCurrentRoom().removeMonster(this);
    }

    @Override
    public String toString() {
        return "Monster " + super.toString();
    }
}
