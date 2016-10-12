package fil.coo.personnage;

import fil.coo.AdventureGame;
import fil.coo.room.Room;

/**
 * This class describe character
 * @author deregnaucourt
 */
public abstract class GameCharacter {

    private AdventureGame ag;
    private Room currentRoom;
    private int strength;
    private int health;
    private int gold;
    private final String name;

    public GameCharacter(String name, int strength, int health, int gold, Room currentRoom) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.gold = gold;
        this.currentRoom = currentRoom;
    }

    /**
     * Return instance of the game adventure.
     *
     * @return The game adventure reference
     */
    public AdventureGame getGame() {
        return this.ag;
    }

    /**
     * Return name of character
     *
     * @return The name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return strength of character
     *
     * @return The strength
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Return current room.
     *
     * @return current room
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Change current room.
     *
     * @param room The new room
     */
    public void changeCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Current amount of life of the character.
     *
     * @return The amount of life
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Current amount of gold owned of character.
     *
     * @return The amount of gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Change the reference to the game
     *
     * @param ag The new game reference
     */
    public void setGame(AdventureGame ag) {
        this.ag = ag;
    }

    /**
     * Change strength of character
     *
     * @param strength The new strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Change the health point of character
     *
     * @param health The new health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Change of amout of gold owned by the character
     *
     * @param gold The new amout of gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Return if character still alive.
     *
     * @return The life or deaf of character
     */
    public boolean isDead() {
        return this.health <= 0;
    }

    /**
     * Kill the character
     */
    public abstract void die();

    /**
     * Attack another game character
     *
     * @param gc - The GameCharacter to attack
     */
    public void attack(GameCharacter gc) {
        gc.setHealth(gc.getHealth() - this.getStrength());
    }

    @Override
    public String toString() {
        return this.getName() + " hp: " + this.getHealth() + ", strength: "
                + this.getStrength() + ", gold: " + this.getGold();
    }
}
