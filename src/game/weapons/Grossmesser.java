package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A class that represents the Grossmesser weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem {

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "slashes", 85);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        // TODO: create Spinning Attack skill
        return super.getSkill(target, direction);
    }
}
