package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * A class that represents the quickstep action.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class QuickStepAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used to attack
     */
    public QuickStepAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc., and the direction the actor moves
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location finalDestination = map.locationOf(target);
        String finalDirection = "to the same location";
        ArrayList<Location> destinations = new ArrayList<>();
        ArrayList<String> directions = new ArrayList<>();

        for (Exit exit: map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                destinations.add(destination);
                directions.add(exit.getName());
            }
        }

        if (!destinations.isEmpty()) {
            int randomInt = RandomNumberGenerator.getRandomInt(destinations.size());
            finalDestination = destinations.get(randomInt);
            finalDirection = directions.get(randomInt);
        }

        String result = new AttackAction(target, direction, weapon).execute(actor, map);

        result += System.lineSeparator() + new MoveActorAction(finalDestination, finalDirection).execute(actor, map);

        return result;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs quickstep on " + target + " at " + direction + " with " + weapon;
    }
}