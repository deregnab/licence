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
    /**
     * Add strength to the Player
     *
     * @param p Player
     */
    @Override
    public void isUsedBy(Player p) {
        p.setStrength(p.getStrength() + this.strength);
    }

    @Override
    public String toString() {
        return "Strength Potion : " + this.strength + " strength.";
    }
}
