package main.personnage;
//import java.util.List;
import java.util.Map;

import main.action.Action;
/**
 *
 * @author moulard
 */
public class Player extends GameCharacter {
    
    private Map<String, Action> actions;
    public Player(String name, int strength, int health, int gold) {
        super(name, strength, health, gold);
    }
    
    /**
     * Add an new action the current action list.
     * @param The new action.
     */
    public void addAction(Action action) {
         
    }
    
    /**
     * Return specified action.
     * @param Wanted action
     * @return the action
     */
    public Action getAction(String action) {
        return null;
    }
    
 /*   private List<Action> possibleActions() {
        return null;
    }
   */ 
    /**
     * Do an action.
     */
    public void act() {
        
    }
    
    /**
     * Attack specified character.
     * @param Character to ba attack
     */
    public void attack(GameCharacter gc) {
        
    }
}