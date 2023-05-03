package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.players.Bandit;
import game.actors.players.Player;
import game.actors.players.Samurai;
import game.actors.players.Wretch;
import java.util.ArrayList;

/**
 * A menu GUI implementation to choose the starting class of the player.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class StartingClassMenu {
    private static StartingClassMenu instance;
    private Display display;
    private ArrayList<Character> choices;

    /**
     * Constructor
     */
    private StartingClassMenu() {
        this.display = new Display();
        choices = getChoices();
    }

    /**
     * This method gets input from the user, if the input is a valid choice, a player with the chosen starting class is created
     * @return new player with chosen starting class
     */
    public Player chooseStartingClass() {
        display.println("Select your starting class: ");
        display.println("s: Samurai");
        display.println("b: Bandit");
        display.println("w: Wretch");

        char choice;
        do {
            choice = display.readChar();
        } while (!choices.contains(choice));

        if (choice == 's') {
            return new Samurai();
        }
        else if (choice == 'b') {
            return new Bandit();
        }
        else if (choice == 'w') {
            return new Wretch();
        }
        return null;
    }

    /**
     * This method implements the valid characters where each character represents a certain starting class
     * @return an array list of characters that are valid
     */
    public ArrayList<Character> getChoices() {
        ArrayList<Character> choices = new ArrayList<>();
        choices.add('s');
        choices.add('b');
        choices.add('w');
        return choices;
    }

    /**
     * This method returns an instance of Starting Class menu. It makes sure that there is only one instance of Starting Class Menu.
     * @return the instance of the Starting Class Menu
     */
    public static StartingClassMenu getInstance(){
        if (instance == null){
            instance = new StartingClassMenu();
        }
        return instance;
    }
}
