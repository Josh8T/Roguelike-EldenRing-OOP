package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Status;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;

import java.util.Random;
/**
 * A class that figures out an attack action of an actor upon another actor
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Josh Hernett Tan
 */
public class AttackBehaviour implements Behaviour{

    /**
     *
     * This method checks for the surrounding enemies, if the actor and the target has the same typing then it wouldn't attack.
     * But if the actor and target has different typing then it checks whether the actor has a weapon or not.
     * if it has a weapon then it will use the weapon skill to attack (the only two enemies that has weapons, it's weapon has skills),
     * if not the actor would use its intrinsic weapon to attack.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an Attack Action or a weapon skill which is also a type of attack action (Area Attack Action)
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location actorLocation = map.locationOf(actor);
        for (Exit targetExit : actorLocation.getExits()){
            Actor aSingularTarget = targetExit.getDestination().getActor();
            if (actor.hasCapability(Status.SKELETON) && aSingularTarget.hasCapability(Status.SKELETON)){
                return null;
            }
            else if (actor.hasCapability(Status.BEAST) && aSingularTarget.hasCapability(Status.BEAST)){
                return null;
            }
            else if (actor.hasCapability(Status.CRUSTACEAN) && aSingularTarget.hasCapability(Status.CRUSTACEAN)){
                return null;
            }
            else if (aSingularTarget != null && aSingularTarget.hasCapability(Status.HOSTILE_TO_ENEMY)){
                if (!actor.getWeaponInventory().isEmpty()) {
                    Weapon actorWeapon = actor.getWeaponInventory().get(0);
                    return actorWeapon.getSkill(aSingularTarget,targetExit.getName());
                }
                else {
                    return new AttackAction(aSingularTarget,targetExit.getName());
                    //TODO haven't implement enemy with slams
                }
            }
        }

        return null;
    }
}
