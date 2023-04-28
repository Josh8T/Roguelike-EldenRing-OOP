package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

/**
 * A class that represents the Giant Crayfish's intrinsic weapon.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class GiantCrayfishPincer extends WeaponItem {

    /**
     * Constructor.
     */
    public GiantCrayfishPincer(){
        super("Giant Crayfish Pincer", 'V', 527, "pinch", 100);
        this.togglePortability();
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
