package fil.coo.item;

import java.util.Random;
import fil.coo.personnage.Player;

/**
 * Exchanges 20 gold coins a randomized item
 * @author Benjamin
 *
 */

public class OneArmedBandit extends Item {
	private int price;
	private int possibleHealth;
	private int possibleStrength;
	
	public OneArmedBandit(int price,int possibleStrength, int possibleHealth){
		this.possibleHealth=possibleHealth;
		this.possibleStrength=possibleStrength;
		this.price=price;
		
	}
	
	@Override
	public int isUsedBy(Player p) {
		if(p.getGold()>=price){
			Random r =new Random();
			int value = r.nextInt()*2;
			if (value==1){
				StrengthPotion sp = new StrengthPotion(possibleStrength);
				sp.isUsedBy(p);
				p.setGold(p.getGold()-price);
			}
			else{
				HealthPotion hp = new HealthPotion(possibleHealth);
				hp.isUsedBy(p);
				p.setGold(p.getGold()-price);
			}
		}
		else{
			System.out.println("You're too poor");
			return 0;
		}
		return 1;
	}
	
	public String toString(){
		
		return "OneArmed Bandit : price : "+price+" Possible Strenght Gain : "+possibleStrength+" Possible Health Gain : "+possibleHealth;
	}
	
	

}
