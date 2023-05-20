package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.EnemyType;
import game.actions.AttackAction;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that figures out an attack action of an actor upon another actor
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi, David Lee
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
        ArrayList<Actor> targets = new ArrayList<>();
        ArrayList<String> directions = new ArrayList<>();

        Location actorLocation = map.locationOf(actor);
        for (Exit exit : actorLocation.getExits()){
            Actor target = exit.getDestination().getActor();
            if (target != null) {
                if (!actor.findCapabilitiesByType(EnemyType.class).equals(target.findCapabilitiesByType(EnemyType.class))){
                    targets.add(target);
                    directions.add(exit.getName());
                }
            }
        }

        if (targets.isEmpty()) {
            return null;
        }

        int randomInt = RandomNumberGenerator.getRandomInt(targets.size());
        Actor finalTarget = targets.get(randomInt);
        String finalDirection = directions.get(randomInt);

        if (!actor.getWeaponInventory().isEmpty()) {
            Weapon actorWeapon = actor.getWeaponInventory().get(0);
            if (rand.nextInt(100) <= 50){
                return new AttackAction(finalTarget, finalDirection, actorWeapon);
            } else {
                Action skill = actorWeapon.getSkill(finalTarget, finalDirection);
                if (skill == null) {
                    return new AttackAction(finalTarget, finalDirection, actorWeapon);
                }
                return skill;
            }
        } else {
            return new AttackAction(finalTarget, finalDirection);
        }
    }
}
