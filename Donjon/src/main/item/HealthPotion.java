package main.item;

import main.personnage.Player;

/**
 * 
 * @author deregnaucourt
 *
 */
public class HealthPotion extends Item{

	int health;
	public HealthPotion(int health){
		this.health=health;
		
	}
	 @Override
	    public void isUsedBy(Player p) {
	        p.setHealth(p.getHealth() + this.health);
	    }

	    @Override
	    public String toString() {
	        return "Health Potion : " + this.health + " health.";
	    }
}
