package main.item;

import main.personnage.Player;

public class Gold extends Item {
	int gold;
	
	public Gold(int gold){
		
		this.gold=gold;
	}
	  /**
     * Add gold to the Player
     *
     * @param p Player
     */
    @Override
    public void isUsedBy(Player p) {
        p.setGold(p.getGold() + this.gold);
    }

    @Override
    public String toString() {
        return "Gold Purse : " + this.gold + " gold.";
    }
}
