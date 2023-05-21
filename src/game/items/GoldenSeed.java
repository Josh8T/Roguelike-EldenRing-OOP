package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Consumable;
import game.actions.ConsumeAction;
import static game.actors.players.StartingClass.flaskOfCrimsonTears;
/**
 * An item class that represents the Golden seed consumable item
 * Created by:
 * @author Josh Hernett Tan
 * Modified by:
 *
 */
public class GoldenSeed extends Item implements Consumable {

    private ConsumeAction consumeGoldenSeed = new ConsumeAction(this);


    /***
     * Constructor.
     */
    public GoldenSeed() {
        super("Golden Seed", 'ø', true);
    }

    /**
     * If actor pickup the item then the consume action will be added to the list of allowable actions
     *
     * @param currentLocation the current location of the item
     * @param actor the actor who picked up the item
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeGoldenSeed)) {
            this.addAction(consumeGoldenSeed);
        }
    }

    /**
     * Consume method from consumable interface
     * increase the maximum amount of flask of crimson tears the actor can hold if the actor has the flask of crimson tears,
     * if the actor does not have a flask then nothing happens
     *
     * @param actor the actor who consume the item
     */
    @Override
    public void consume(Actor actor) {
        if(actor.getItemInventory().contains(flaskOfCrimsonTears)){
            flaskOfCrimsonTears.setMaxAmount(flaskOfCrimsonTears.getMaxAmount()+1);
            actor.removeItemFromInventory(this);
        }
    }

    @Override
    public boolean isEmpty() {
        return Consumable.super.isEmpty();
    }
}
