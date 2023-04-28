package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

public class GiantCrayfishPincer extends WeaponItem {
    public GiantCrayfishPincer(){
        super("Giant Crayfish Pincer", 'V', 527, "pinch", 100);
        this.togglePortability();
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
