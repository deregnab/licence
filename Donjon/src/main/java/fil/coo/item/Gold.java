package fil.coo.item;


import fil.coo.personnage.Player;

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
    public int isUsedBy(Player p) {
        p.setGold(p.getGold() + this.gold);
        return 1;
    }

    @Override
    public String toString() {
        return "Gold Purse : " + this.gold + " gold.";
    }
}
