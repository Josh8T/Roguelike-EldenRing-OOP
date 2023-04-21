package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

public class AreaAttackAction extends Action {

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     * @param weapon the Weapon used to perform area attack
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Constructor with intrinsic weapon as default
     */
    public AreaAttackAction() {
    }

    /**
     * When executed, the Actor attacks every other actor that is in its exits by executing AttackAction on them.
     *
     * @param actor The actor performing the area attack.
     * @param map The map the actor is on.
     * @return that an area attack is performed and results of attacks on each target, e.g. whether the target is killed, etc.
     * @see AttackAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " does an area attack.";

        for (Exit exit: map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                result += System.lineSeparator() + new AttackAction(destination.getActor(), exit.getName(), weapon).execute(actor, map);
            }
        }

        return result;
    }

    /**
     * Describes the weapon that the actor is using to perform the area attack
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " does an area attack with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
