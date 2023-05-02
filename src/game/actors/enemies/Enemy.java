package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.ResetManager;
import game.Resettable;
import game.enums.Status;
import game.actions.AttackAction;
import game.behaviours.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for an Enemy. These represent things that an Enemy can do.
 * Created by:
 * @author David Lee
 * Modified by:
 * @author Josh Hernett Tan
 */
public abstract class Enemy extends Actor implements Resettable {

    /**
     * The behaviours that an Enemy has stored in a hashmap
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constrcutor.
     * @param name the name of the Enemy
     * @param displayChar the character that will represent the Enemy in the display
     * @param hitPoints the Enemy's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.getBehaviours().put(1, new AttackBehaviour());
        this.getBehaviours().put(3, new DeSpawnBehaviour());
        this.getBehaviours().put(4, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Enemy
     * @param lastAction The Action this Enemy took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Enemy
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location actorLocation = map.locationOf(this);
        for (Exit targetExits : actorLocation.getExits()) {
            Actor target = targetExits.getDestination().getActor();
            if (target != null && target.hasCapability(Status.FOLLOWABLE)) {
                this.getBehaviours().put(2, new FollowBehaviour(target));
                behaviours.remove(3);
            }
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * This Enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return the list of actions the Actor can do to the Enemy
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            for (Weapon weapon: otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weapon));
                actions.add(weapon.getSkill(this, direction));
            }
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
        }
        return actions;
    }

    /**
     * Getter for the Enemy's hashmap of behaviours
     * @return hashmap of behaviours
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }

    @Override
    public void reset(GameMap map) {
        ResetManager.getInstance().removeResettable(this);
        map.removeActor(this);
    }
}
