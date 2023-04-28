package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.EnemyType;
import game.Status;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.actors.enemies.Enemy;

import java.util.Random;

/**
 * A class that figures out an attack action of an actor upon another actor
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi
 */
public class AttackBehaviour implements Behaviour {

    Random rand = new Random();

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
        for (Exit exits : actorLocation.getExits()){
            Actor target = exits.getDestination().getActor();
            if (target != null) {
                if (actor.hasCapability(EnemyType.SKELETON) && target.hasCapability(EnemyType.SKELETON)){
                    return null;
                }
                else if (actor.hasCapability(EnemyType.BEAST) && target.hasCapability(EnemyType.BEAST)){
                    return null;
                }
                else if (actor.hasCapability(EnemyType.CRUSTACEAN) && target.hasCapability(EnemyType.CRUSTACEAN)){
                    return null;
                }
                if (!actor.getWeaponInventory().isEmpty()) {
                    Weapon actorWeapon = actor.getWeaponInventory().get(0);
                    if (rand.nextInt(100) <= 50){
                        return new AttackAction(target, exits.getName(), actorWeapon);
                    } else {
                        return actorWeapon.getSkill(target, exits.getName());
                    }
                } else {
                    return new AttackAction(target, exits.getName());
                }
            }
        }
        return null;
    }
}
