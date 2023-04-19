package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A class that represents the Great Knife weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem {

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slashes", 88);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        // TODO: create Spinning Attack skill
        return super.getSkill(target, direction);
    }
}
