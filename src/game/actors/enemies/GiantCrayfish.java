package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AreaAttackAction;

/**
 * A class that represents the Giant Crayfish.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class GiantCrayfish extends Enemy{
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }

    public Action getSkill() {
        return new AreaAttackAction();
    }
}
