package game;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.players.*;

import java.util.ArrayList;

/**
 * A menu GUI implementation to choose the starting class of the player.
 * Created by:
 * @author David Lee
 * Modified by:
 *
 */
public class StartingClassMenu {

    /**
     * The instance of the Starting Menu Class
     */
    private static StartingClassMenu instance;

    private Display display;

    /**
     * An arraylist of String of starting classes
     */
    private ArrayList<String> choices = new ArrayList<>();

    /**
     * Constructor
     */
    private StartingClassMenu() {
        this.display = new Display();
        choices.add("Samurai");
        choices.add("Bandit");
        choices.add("Wretch");
        choices.add("Astrologer");
    }

    /**
     * This method gets input from the user, if the input is a valid choice, a player with the chosen starting class is returned
     * @return new player with chosen starting class
     */
    public StartingClass chooseStartingClass() {
        display.println("Select your starting class: ");
        for (String choice: choices) {
            display.println(choice.toLowerCase().charAt(0) + ": " + choice);
        }

        char mChoice;
        while (true) {
            mChoice = display.readChar();
            if (mChoice == 's') {
                return new Samurai();
            } else if (mChoice == 'b') {
                return new Bandit();
            } else if (mChoice == 'w') {
                return new Wretch();
            } else if (mChoice == 'a') {
                return new Astrologer();
            }
        }
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
