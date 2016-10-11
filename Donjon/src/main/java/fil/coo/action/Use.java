package fil.coo.action;
import fil.coo.item.Item;
import fil.coo.item.OneArmedBandit;
import fil.coo.menu.ActionMenu;
import fil.coo.personnage.Player;
/**
 * 
 * @author deregnaucourt
 *
 */

public class Use extends Action {

    public Use() {
        super("Use Item");
    }

    /**
     * Use the item chosen by the Player p
     *
     * @param p Player
     */
    @Override
    public void execute(Player p) {
        Item i = ActionMenu.choice(p.getCurrentRoom().getItems());
        int value;
        value=i.isUsedBy(p);
        if(value==1){
        p.getCurrentRoom().removeItem(i);
        }
    }

    /**
     * Verify if the Use Item Action is possible on the Player p
     *
     * @param p Player
     * @return true if attack is possible
     */
    @Override
    public boolean isPossible(Player p) {
        return super.isPossible(p) && !p.getCurrentRoom().getItems().isEmpty();
    }
}
