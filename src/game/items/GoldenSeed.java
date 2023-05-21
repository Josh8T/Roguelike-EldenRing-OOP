package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Consumable;
import game.actions.ConsumeAction;
import static game.actors.players.StartingClass.flaskOfCrimsonTears;

public class GoldenSeed extends Item implements Consumable {

    private ConsumeAction consumeGoldenSeed = new ConsumeAction(this);


    /***
     * Constructor.
     */
    public GoldenSeed() {
        super("Golden Seed", 'c', true);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeGoldenSeed)) {
            this.addAction(consumeGoldenSeed);
        }
    }

    @Override
    public void consume(Actor actor) {
        if(actor.getItemInventory().contains(flaskOfCrimsonTears)){
            flaskOfCrimsonTears.setMaxAmount(flaskOfCrimsonTears.getMaxAmount()+1);
            actor.removeItemFromInventory(this);
        };
    }

    @Override
    public boolean isEmpty() {
        return Consumable.super.isEmpty();
    }
}
