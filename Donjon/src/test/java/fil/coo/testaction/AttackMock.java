package fil.coo.testaction;

import fil.coo.action.Attack;
import fil.coo.personnage.Monster;
import fil.coo.personnage.Player;

//import fil.coo.dungeon.character.Monster;
//import fil.coo.dungeon.character.Player;


/**
 *
 * @author moulard
 */
public class AttackMock extends Attack {

    @Override
    public void execute(Player p) {
        Monster m = p.getCurrentRoom().getMonsters().get(1);
        p.attack(m);

        if (m.isDead()) {
            m.die();
        } else {
            m.attack(p);
        }

        if (p.isDead()) {
            p.die();
        }

    }
}
