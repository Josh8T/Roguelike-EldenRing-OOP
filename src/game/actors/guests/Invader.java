package game.actors.guests;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actors.DropsRunes;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.enums.EnemyType;
import game.enums.Status;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents an Invader.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Invader extends Guest implements DropsRunes {

    /**
     * Constructor.
     */
    public Invader() {
        super("Invader", 'ඞ', 0);
        this.addCapability(EnemyType.INVADER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location actorLocation = map.locationOf(this);
        for (Exit targetExits : actorLocation.getExits()) {
            Actor target = targetExits.getDestination().getActor();
            if (target != null && target.hasCapability(Status.FOLLOWABLE)) {
                this.behaviours.put(2, new FollowBehaviour(target));
            }
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            for (Weapon weapon: otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weapon));
                actions.add(weapon.getSkill(this, direction));
            }
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Generates a random value between 1358 - 5578
     * @return a random value of runes
     */
    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(1358,  5578);
    }
}
