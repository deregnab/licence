package fil.coo.item;
import fil.coo.personnage.*;

/**
 * 
 * @author deregnaucourt
 *
 */
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
    public int isUsedBy(Player p) {
        p.setStrength(p.getStrength() + this.strength);
        return 1;
    }

    @Override
    public String toString() {
        return "Strength Potion : " + this.strength + " strength.";
    }
}
