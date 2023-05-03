package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ReviveAction;
import game.enums.EnemyType;
import game.enums.Status;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

/**
 * A class that represents the Heavy Skeletal Swordsman.
 * Created by:
 * @author Aflah Hanif Amarlyadi
 * Modified by:
 * @author Josh Hernett Tan, David Lee
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
        if (this.stateCounter > 0 && this.stateCounter <= 2 && this.hasCapability(Status.RESPAWNABLE)) {
            setStateCounter(this.stateCounter + 1);
        } else if (this.stateCounter == 0 && this.hasCapability(Status.RESPAWNABLE)) {
            this.setDisplayChar('X');
            setStateCounter(this.stateCounter + 1);
        } else if (this.stateCounter == 3 && this.hasCapability(Status.RESPAWNABLE)) {
            setStateCounter(0);
            this.setDisplayChar('q');
            return new ReviveAction(153);
        }

        if (!this.hasCapability(Status.RESPAWNABLE)) {
            Location actorLocation = map.locationOf(this);
            for (Exit targetExits : actorLocation.getExits()) {
                Actor target = targetExits.getDestination().getActor();
                if (target != null && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.getBehaviours().put(2, new FollowBehaviour(target));
                    behaviours.remove(3);
                }
            }
            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                if(action != null)
                    return action;
            }
        }
        return new DoNothingAction();
    }

    @Override
    public int generateRuneValue() {
        return RandomNumberGenerator.getRandomInt(35, 892);
    }
}
