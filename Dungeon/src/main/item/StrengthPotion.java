package main.item;

import main.personnage.Player;

public class StrengthPotion extends Item{
	int strength;
	
	public StrengthPotion(int strength){
		
		this.strength=strength;
	}
	
	public int getStrength(){
		return strength;
		
	}
	@Override
	void isUsedBy(Player p) {
		p.setStrength(p.getStrength()+this.getStrength());
		
	}

}
