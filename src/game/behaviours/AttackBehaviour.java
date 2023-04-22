package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

public class AttackBehaviour implements Behaviour{
    private final Actor target;
    private final Random rand = new Random();

    public AttackBehaviour(Actor target) {
        this.target = target;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        for (Exit hereExit : here.getExits()){
            for (Exit thereExit : there.getExits()){
                if (hereExit == thereExit){
                    //TODO add type checker
                    if (actor.getWeaponInventory() != null){
                        Weapon weapon = actor.getWeaponInventory().get(0);
                        //TODO check if weapon has skill
                    } else {
                        //TODO check if here actor has skill and implement intrinsic weapon attack action
                    }
                }
                else {
                    return null;
                }
            }
        }

        return null;
    }
}
