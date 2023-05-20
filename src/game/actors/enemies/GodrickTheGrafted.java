package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.enums.EnemyType;
import game.enums.Status;
import game.items.RemembranceOfTheGrafted;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

import java.util.List;
/**
 * A class that represents Godrick the Grafted
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * @author Aflah Hanif Amarlyadi, David Lee
 */
public class GodrickTheGrafted extends Enemy{

    private Location spawnLocation;

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    /**
     * Constrcutor.
     */
    public GodrickTheGrafted() {
        super("Godrick the Grafted", 'Y', 400);
        this.addCapability(EnemyType.BOSS);
        this.addCapability(Status.FIRST_PHASE);
        behaviours.remove(3);
        this.addWeaponToInventory(new AxeOfGodrick());
        this.addWeaponToInventory(new GraftedDragon());
        this.addItemToInventory(new RemembranceOfTheGrafted());
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        Location actorLocation = map.locationOf(this);
        for (Exit targetExits : actorLocation.getExits()) {
            Actor target = targetExits.getDestination().getActor();
            if (target != null && target.hasCapability(Status.FOLLOWABLE)) {
                this.getBehaviours().put(2, new FollowBehaviour(target));
            }
        }

        if (this.hitPoints <= this.maxHitPoints / 2 && this.hasCapability(Status.FIRST_PHASE)) {
            this.removeCapability(Status.FIRST_PHASE);
            this.addCapability(Status.SECOND_PHASE);
            this.removeWeaponFromInventory(getWeaponInventory().get(0));
        }

        for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                if(action != null)
                    return action;
        }
        return new DoNothingAction();
    }


    @Override
    public int generateRuneValue() {
        return 20000;
    }

    /**
     * The reset works by moving Godrick back to where it initially spawns, and heal it to max HP if not already.
     * But works only if the Godrick has not been defeated
     */
    @Override
    public void reset(GameMap map) {
        if (this.isConscious()){
            map.moveActor(this, this.getSpawnLocation());
            this.heal(999999);
        }
    }
}
