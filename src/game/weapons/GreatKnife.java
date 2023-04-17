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
public class GreatKnife extends WeaponItem {

    /**
     * Constructor.
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "stabs", 70);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        // TODO: create QuickStep skill
        return super.getSkill(target, direction);
    }
}
