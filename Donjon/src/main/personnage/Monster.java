package main.personnage;
import main.personnage.*;
import main.room.Room;
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
    public void die() {
        
    }
    @Override
    public String toString() {
        return "Monster{" + '}';
    }
}