package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ReviveSkeletonAction;
import game.enums.EnemyType;
import game.enums.Status;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.weapons.Grossmesser;

/**
 * A class that represents the Heavy Skeletal Swordsman.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Josh Hernett Tan
 */
public class HeavySkeletalSwordsman extends Enemy {
    private int stateCounter;

    public int getStateCounter() {
        return stateCounter;
    }

    public void setStateCounter(int stateCounter) {
        this.stateCounter = stateCounter;
    }

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addCapability(EnemyType.SKELETON);
        this.addWeaponToInventory(new Grossmesser());
        this.stateCounter = 0;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.stateCounter > 0 && this.stateCounter <= 2 && this.hasCapability(Status.PILE_OF_BONES)) {
            setStateCounter(this.stateCounter + 1);
            return new DoNothingAction();
        } else if (this.stateCounter == 0 && !(this.isConscious())) {
            this.setDisplayChar('X');
            behaviours.clear();
            setStateCounter(this.stateCounter + 1);
            return new DoNothingAction();
        } else if (this.stateCounter == 2 && this.hasCapability(Status.PILE_OF_BONES)) {
            setStateCounter(0);
            this.setDisplayChar('q');
            return new ReviveSkeletonAction(this, 153);
        }

        if (this.hasCapability(EnemyType.SKELETON)) {
            Location actorLocation = map.locationOf(this);
            for (Exit targetExits : actorLocation.getExits()) {
                Actor target = targetExits.getDestination().getActor();
                if (target != null) {
                    this.getBehaviours().put(2, new FollowBehaviour(target));
                }
            }
            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }
}
