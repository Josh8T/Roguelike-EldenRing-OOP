package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ResetManager;
import game.actors.guests.Ally;
import game.actors.guests.Guest;
import game.actors.guests.Invader;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * A class that represents the summon action.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class SummonAction extends Action {
    /**
     * Location of the summon sign
     */
    Location signLocation;

    /**
     * Constructor
     *
     * @param signLocation location of the summon sign
     */
    public SummonAction(Location signLocation) {
        this.signLocation = signLocation;
    }

    /**
     * When executed, either an Ally or an Invader will spawn in one of the available exits of the summon sign
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the guest that is summoned.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        Guest guest;
        int randomInt = RandomNumberGenerator.getRandomInt(2);

        if (randomInt == 0) {
            guest = new Ally();
            result += System.lineSeparator() +"A friendly guest has arrived.";
        } else {
            guest = new Invader();
            result += System.lineSeparator() + "A hostile guest has arrived. Prepare for battle!";
        }
        ResetManager.getInstance().registerDeathResettable(guest);

        ArrayList<Location> summonLocations = new ArrayList<>();

        for (Exit exit: signLocation.getExits()) {
            Location destination = exit.getDestination();
            if (!destination.containsAnActor()) {
                summonLocations.add(destination);
            }
        }

        if (!summonLocations.isEmpty()) {
            summonLocations.get(RandomNumberGenerator.getRandomInt(summonLocations.size())).addActor(guest);
        } else {
            return "Summoning is not possible";
        }
        return result;
    }

    /**
     * Describes the action of summoning a guest by the actor
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest from another realm";
    }
}
