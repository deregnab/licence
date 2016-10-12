package fil.coo.item;

import fil.coo.personnage.Player;

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
	    public int isUsedBy(Player p) {
	        p.setHealth(p.getHealth() + this.health);
	        return 1;
	    }

	    @Override
	    public String toString() {
	        return "Health Potion : " + this.health + " health.";
	    }

}
