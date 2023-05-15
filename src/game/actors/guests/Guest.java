package game.actors.guests;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ResetManager;
import game.Resettable;
import game.actors.players.*;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * A base class that represents a Guest.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public abstract class Guest extends Actor implements Resettable {
    /**
     * The starting class of the Guest
     */
    StartingClass startingClass;

    /**
     * The behaviours that the Guest has stored in a hashmap
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Guest
     * @param displayChar the character that will represent the Guest in the display
     * @param hitPoints   the Guest's starting hit points
     */
    public Guest(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        int randomInt = RandomNumberGenerator.getRandomInt(4);
        if (randomInt == 0) {
            this.startingClass = new Samurai();
        } else if (randomInt == 1) {
            this.startingClass = new Bandit();
        } else if (randomInt == 2) {
            this.startingClass = new Wretch();
        } else {
            this.startingClass = new Astrologer();
        }
        this.increaseMaxHp(startingClass.getHp());
        this.addWeaponToInventory(startingClass.getWeaponInventory().get(0));
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(3, new WanderBehaviour());
    }

    @Override
    public void reset(GameMap map) {
        ResetManager.getInstance().removeResettable(this);
        map.removeActor(this);
    }
}
