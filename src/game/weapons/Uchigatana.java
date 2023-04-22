package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.MultipliedDamageAction;

/**
 * A class that represents the Uchigatana weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem {

    /**
     * Constructor.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        // TODO: create Unsheathe skill
        return new MultipliedDamageAction(target, direction, this, 2, 60);
    }
}
