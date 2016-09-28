package main.item;

import main.personnage.Player;

public class Gold extends Item {
	int gold;
	
	public Gold(int gold){
		
		this.gold=gold;
	}
	
	public int getGold(){return gold;}
	@Override
	void isUsedBy(Player p) {
		// TODO Auto-generated method stub
		p.setGold(p.getGold()+this.getGold());
	}

}
