package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
/**
 * An action executed to revive a skeleton from pile of bones.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author David Lee
 */
public class ReviveSkeletonAction extends Action {

    private int originalHitPoint;
    public ReviveSkeletonAction(int hitPoint) {
        this.originalHitPoint = hitPoint;
    }

    @Override
    public String execute(Actor target, GameMap map) {
        target.removeCapability(Status.PILE_OF_BONES);
        target.resetMaxHp(originalHitPoint);
        return menuDescription(target);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has revived!";
    }
}
