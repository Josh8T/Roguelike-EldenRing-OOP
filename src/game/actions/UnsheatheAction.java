package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * A class that represents the unsheathe action.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class UnsheatheAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * The hit chance of the attack
     */
    private int hitChance;

    /**
     * Constructor
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used to attack
     * @param hitChance the hit chance of the attack
     */
    public UnsheatheAction(Actor target, String direction, Weapon weapon, int hitChance) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
        this.hitChance = hitChance;
    }

    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal double damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!(rand.nextInt(100) <= hitChance)) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage() * 2;
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }

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
        return actor + " unsheathes " + weapon + " on " + target + " at " + direction;
    }
}