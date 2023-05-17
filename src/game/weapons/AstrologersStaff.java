package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Purchasable;
import game.Sellable;
import game.actions.AttackAction;
import game.actions.SellAction;

public class AstrologersStaff extends WeaponItem implements Purchasable, Sellable {

    private SellAction sellAstrologersStaff = new SellAction(this, 100);

    /**
     * Constructor.
     */
    public AstrologersStaff() {
        super("Astrologer's Staff", 'f', 274, "shoots", 50);
    }

    /**
     * Checks whether a trader is nearby and gives the player an action to sell the weapon.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (traderNearby(currentLocation) && !this.getAllowableActions().contains(sellAstrologersStaff)) {
            this.addAction(sellAstrologersStaff);
        }
        if (!traderNearby(currentLocation)) {
            this.removeAction(sellAstrologersStaff);
        }
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AttackAction(target, direction, this);
    }

    @Override
    public void takePurchasable(Actor actor) {
        actor.addWeaponToInventory(this);
    }

    @Override
    public void giveSellable(Actor actor) {
        actor.removeWeaponFromInventory(this);
    }
}
