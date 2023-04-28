package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.UnsheatheAction;

/**
 * A class that represents the Uchigatana weapon.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author David Lee
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
        return new UnsheatheAction(target, direction, this, 60);
    }
}
