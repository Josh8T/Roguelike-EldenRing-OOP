package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.actors.DropsRunes;
import game.enums.EnemyType;
import game.enums.ItemType;
import game.enums.Status;
import game.grounds.environments.SiteOfLostGrace;
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
     * If player is killed, drop runes and reset the game.
     * If player kills a target, the items & weapons carried by target will drop at the location in the game map where
     * the target was
     * If killed by an actor that is not the player, only the weapons carried by the target will drop.
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

        if (target.hasCapability(EnemyType.BOSS)){
            // Doesn't drop weapons but drop Items
            // the location of the boss death will be a new Site of lost grace
            map.locationOf(target).setGround(new SiteOfLostGrace("Godrick's Grace", map.locationOf(target)));
            // drop all droppable items of Boss
            for (Item item : target.getItemInventory()) {
                if (item.hasCapability(ItemType.DROPPABLE)) {
                    dropActions.add(item.getDropAction(target));
                }
            }
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove Boss
            map.removeActor(target);

        }
        // if target is skeleton
        else if (target.hasCapability(EnemyType.SKELETON) && !target.hasCapability(Status.RESPAWNABLE)){
            target.resetMaxHp(1);
            target.addCapability(Status.RESPAWNABLE);
            return System.lineSeparator() + target + " turns into a pile of bones";
        }
        // if player dies
        else if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            for (String line : FancyMessage.YOU_DIED.split("\n")) {
                result += System.lineSeparator() + line;
            }
            // reset game
            new ResetAction().execute(target, map);
            // drop runes
            new DropRuneAction(RuneManager.getInstance().getRune()).execute(target, map);
        }
        // if attacker is player
        else if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // drop runes of killed enemies
            if (!target.findCapabilitiesByType(EnemyType.class).isEmpty()) {
                RuneManager.getInstance().awardKill((DropsRunes) target);
            }
            // drop all droppable items of target
            for (Item item : target.getItemInventory()) {
                if (item.hasCapability(ItemType.DROPPABLE)) {
                    dropActions.add(item.getDropAction(target));
                }
            }
            // drop all weapons of target
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove target
            map.removeActor(target);
        }
        // if attacker is not player
        else if (!attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // drop all weapons of target
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove target
            map.removeActor(target);
        }

        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
