package main.personnage;

import main.AdventureGame;

/**
 * This class describe character
 * @author moulard
 */
public abstract class GameCharacter {
    private AdventureGame ag;
    private int strength;
    private int health;
    private int gold;
    private final String name;
    
    public GameCharacter(String name, int strength, int health, int gold) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.gold = gold;
    }
    /**
     * Return instance of the game adventure.
     * @return The game adventure reference
     */
    public AdventureGame getGame() {
        return ag;
    }
    /**
     * Return strength of character
     * @return The strength
     */
    public int getStrength() {
        return strength;
    }
    /**
     * Current amount of life of the character.
     * @return The amount of life
     */
    public int getHealth() {
        return health;
    }
    /**
     * Current amount of gold owned of character.
     * @return The amount of gold
     */
    public int getGold() {
        return gold;
    }
    /**
     * Change the reference to the game
     * @param ag The new game reference
     */
    public void setGame(AdventureGame ag) {
        this.ag = ag;
    }
    /**
     * Change strength of character
     * @param strength The new strength 
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
    /**
     * Change the health point of character
     * @param health The new health 
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * Change of amout of gold owned by the character
     * @param gold The new amout of gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    @Override
    public String toString() {
        return "GameCharacter{" + "ag=" + ag + ", strength=" + strength + ", health=" + health + ", gold=" + gold + ", name=" + name + '}';
    }
    
    /**
     * Return if character still alive.
     * @return The life or deaf of character
     */
    public boolean isDead() {
        return false;
    }
    
    /**
     * Kill the character
     */
    public void die() {
        
    }
    
    /**
     * Attack another game character
     * @param The GameCharacter to be attack
     */
    public void attack(GameCharacter gc) {
        
    }
}