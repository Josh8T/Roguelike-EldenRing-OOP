package game.actors.guests;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.enums.EnemyType;
import game.enums.Status;

/**
 * A class that represents an Invader.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Invader extends Guest {

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
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
