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
	
	public int getHealth(){return health;}
	@Override
	void isUsedBy(Player p) {
		p.setHealth(p.getHealth()+this.getHealth());
		
	}

}
