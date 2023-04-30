package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.enemies.Enemy;
import game.enums.EnemyType;
import game.enums.Status;
/**
 * An action executed to revive a skeleton from pile of bones.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class ReviveSkeletonAction extends Action {
    private Enemy revivingEnemy;
    private int originalHitPoint;
    public ReviveSkeletonAction(Enemy enemy, int hitPoint) {
        this.revivingEnemy = enemy;
        this.originalHitPoint = hitPoint;
    }

    @Override
    public String execute(Actor target, GameMap map) {
        target.addCapability(EnemyType.SKELETON);
        target.removeCapability(Status.PILE_OF_BONES);
        target.resetMaxHp(originalHitPoint);
        return target + menuDescription(target);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has revived!";
    }
}
