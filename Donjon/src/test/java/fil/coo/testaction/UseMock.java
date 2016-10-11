package fil.coo.testaction;

import fil.coo.personnage.Player;
import fil.coo.item.Item;
import fil.coo.action.Use;

/**
 *
 * @author moulard
 */
public class UseMock extends Use{

    @Override
    public void execute(Player p) {
        Item i = p.getCurrentRoom().getItems().get(1);
        i.isUsedBy(p);
        p.getCurrentRoom().removeItem(i);
    }
}
