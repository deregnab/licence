package main.action;

import main.item.Item;
import main.menu.ActionMenu;
import main.personnage.Player;

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
        i.isUsedBy(p);
        p.getCurrentRoom().removeItem(i);
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
