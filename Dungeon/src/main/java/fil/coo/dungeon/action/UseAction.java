package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.item.Item;
import fil.coo.dungeon.menu.MenuAction;

/**
 * UseAction is an Action that can executed by the Player to use an Item
 *
 * @author seysn
 */
public class UseAction extends Action {

    public UseAction() {
        super("Use Item");
    }

    /**
     * Use the item chosen by the Player p
     *
     * @param p Player
     */
    @Override
    public void execute(Player p) {
        Item i = MenuAction.choice(p.getCurrentRoom().getItems());
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
