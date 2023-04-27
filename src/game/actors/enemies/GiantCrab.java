package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;

/**
 * A class that represents the Giant Crab enemy.
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 * 
 */
public class GiantCrab extends Enemy{
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
        this.addCapability(Status.CRUSTACEAN);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }




}
