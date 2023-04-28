package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;

public class GiantDogHead extends WeaponItem {
    public GiantDogHead(){
        super("Giant Dog Head", 'D', 314, "scratch", 90);
        this.togglePortability();
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
