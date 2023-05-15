package game.actors.guests;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;

/**
 * A class that represents an Ally.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class Ally extends Guest {

    /**
     * Constructor.
     */
    public Ally() {
        super("Ally", 'A', 0);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
