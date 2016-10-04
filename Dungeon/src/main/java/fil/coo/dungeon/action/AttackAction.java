package fil.coo.dungeon.action;

import fil.coo.dungeon.character.Monster;
import fil.coo.dungeon.character.Player;
import fil.coo.dungeon.menu.MenuAction;

/**
 * AttackAction is an Action that can executed by the Player to damage a Monster
 *
 * @author seysn
 */
public class AttackAction extends Action {

    public AttackAction() {
        super("Attack");
    }

    /**
     * Trigger the Attack Action on Player p
     *
     * @param p Player
     */
    @Override
    public void execute(Player p) {
        Monster m = MenuAction.choice(p.getCurrentRoom().getMonsters());

        System.out.println(p.getName() + " is attacking " + m.getName());
        p.attack(m);
        if (m.isDead()) {
            m.die();
            System.out.println(m.getName() + " is now dead");
            return;
        } else {
            System.out.println(m.getName() + " has now " + m.getHealth() + " hp");
        }

        System.out.println(m.getName() + " is attacking " + m.getName());
        m.attack(p);
        if (p.isDead()) {
            p.die();
            System.out.println(p.getName() + " is now dead");
        } else {
            System.out.println(p.getName() + " has now " + p.getHealth() + " hp");
        }
    }

    /**
     * Verify if the Attack Action is possible on the Player p
     *
     * @param p Player
     * @return true if attack is possible
     */
    @Override
    public boolean isPossible(Player p) {
        return super.isPossible(p) && !p.getCurrentRoom().getMonsters().isEmpty();
    }
}
