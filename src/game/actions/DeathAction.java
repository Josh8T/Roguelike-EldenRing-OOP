package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.actors.DropsRunes;
import game.enums.EnemyType;
import game.enums.ItemType;
import game.enums.Status;
import game.items.RuneManager;

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
     * When the target is killed, the items & weapons carried by target will drop at the location in the game map where
     * the target was, except if both target and attacker is Enemy, only the weapons carried by the target will drop.
     * Skeleton type enemies are not dead the moment it is no longer conscious but instead becomes pile of bones.
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = System.lineSeparator() + menuDescription(target);
        ActionList dropActions = new ActionList();

        if (target.hasCapability(EnemyType.SKELETON) && !target.hasCapability(Status.RESPAWNABLE)){
            target.resetMaxHp(1);
            target.addCapability(Status.RESPAWNABLE);
            return System.lineSeparator() + target + " turns into a pile of bones";
        }
        else if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            for (String line : FancyMessage.YOU_DIED.split("\n")) {
                result += System.lineSeparator() + line;
            }
            // drop all droppable items
            for (Item item : target.getItemInventory()) {
                if (item.hasCapability(ItemType.DROPPABLE)) {
                    dropActions.add(item.getDropAction(target));
                }
            }
            for (Action drop : dropActions)
                drop.execute(target, map);
            new ResetAction(false).execute(target, map);
        }
        else if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if (!target.findCapabilitiesByType(EnemyType.class).isEmpty()) {
                RuneManager.getInstance().awardKill((DropsRunes) target);
            }
            // drop all droppable items
            for (Item item : target.getItemInventory()) {
                if (item.hasCapability(ItemType.DROPPABLE)) {
                    dropActions.add(item.getDropAction(target));
                }
            }
            // drop all weapons
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
        }
        else if (!attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // only drop weapons and remove actor
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            map.removeActor(target);
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
