package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.ResetManager;
import game.enums.EnemyType;
import game.enums.ItemType;
import game.enums.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Josh Hernett Tan
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was.
     * Skeleton type enemies are not dead the moment it is no longer conscious but instead becomes pile of bones.
     * If an enemy kills another enemy, it would drop any items.
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        ActionList dropActions = new ActionList();

        if (target.hasCapability(EnemyType.SKELETON) && !target.hasCapability(Status.INCAPACITATED)){
            target.resetMaxHp(1);
            target.addCapability(Status.INCAPACITATED);
            return System.lineSeparator() + target + " turns into a pile of bones";
        }
        else if (target.hasCapability(Status.PLAYER)) {
            for (String line : FancyMessage.YOU_DIED.split("\n")) {
                new Display().println(line);
            }
            ResetManager.getInstance().run(map);
        }
        else if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
            // drop all droppable items
            for (Item item : target.getItemInventory())
                if (item.hasCapability(ItemType.DROPPABLE)) {
                    dropActions.add(item.getDropAction(target));
                }
            // drop all weapons
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
        }
        else if (!attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
            // only drop weapons and remove actor
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            map.removeActor(target);
        }

        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
