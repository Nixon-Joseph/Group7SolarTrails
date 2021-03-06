/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.solarTrails.view;

import group7solartrails.Group7SolarTrails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Hiatt-Adam
 */
public class ChooseCrewSizeView extends View{
    public static int crewSize;
    public ChooseCrewSizeView () {
        super("\n"
            + "\n-----------------------------------"
            + "\n | Pick your crew members."
            + "\n-----------------------------------"
            + "\n1 - Only you will take this trip. This provides the highest amount of points but is also more dangerous."
            + "\n2 - You and one other will take this trip."
            + "\n3 - You and two others will take this trip. This is the maximum size for a small ship size."
            + "\n4 - You and three others will take this trip."
            + "\n5 - You and four others will take this trip."
            + "\n6 - You and five others will take this trip. This is the maximum size for a medium ship size."
            + "\n7 - You and six others will take this trip."
            + "\n8 - You and seven others will take this trip."
            + "\n9 - You and eight others will take this trip. This is the maximum size for a large ship size."
            + "\nR - Reset currently selected ship options"
            + "\nD - Go Back to the previous menu"
            + "\n------------------------------------");
    }

    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        boolean isTooHigh = false;
        if (Integer.parseInt(value) > Group7SolarTrails.getShip().getMaxCrew()) {
            isTooHigh = true;
            this.console.println("\n*** Crew Selection too high *** "
                                + "\n*** Your max crew size is " + Group7SolarTrails.getShip().getMaxCrew() + " ***"
                                + "\nPress enter to try again");
            choice = 'p';
        }
        switch (choice) {
            case '1': // create and start a new game
                this.crewSizeOne();
                break;
            case '2': // get and start an existing game
                this.crewSizeTwo();
                break;
            case '3': // get and start an existing game
                this.crewSizeThree();
                break;
            case '4': // get and start an existing game
                this.crewSizeFour();
                break;
            case '5': // get and start an existing game
                this.crewSizeFive();
                break;
            case '6': // get and start an existing game
                this.crewSizeSix();
                break;
            case '7': // get and start an existing game
                this.crewSizeSeven();
                break;
            case '8': // get and start an existing game
                this.crewSizeEight();
                break;
            case '9': // get and start an existing game
                this.crewSizeNine();
                break;
            case 'R': // display the help menu
                this.resetCrewOptions();
                break;
            case 'D': // Exit the program
                this.previousMenu();
                break;
            default:
                try {
                    if (!isTooHigh) {
                        this.console.println("\n*** Invalid selection *** "
                                            + "\nPrease enter to try again");
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return false;
    }

    private void crewSizeOne() {
        crewSize = 1;
        // Going it alone
        Group7SolarTrails.getShip().setNoCrew(1);
        this.console.println("You have decided to go with only one crew member.");
        getNextView();
    }

    private void crewSizeTwo() {
        crewSize = 2;
        Group7SolarTrails.getShip().setNoCrew(2);
        this.console.println("You have decided to go with two crew members.");
        getNextView();
    }

    private void crewSizeThree() {
        crewSize = 3;
        Group7SolarTrails.getShip().setNoCrew(3);
        this.console.println("You have decided to go with three crew members.");
        getNextView();
    }

    private void crewSizeFour() {
        crewSize = 4;
        Group7SolarTrails.getShip().setNoCrew(4);
        this.console.println("You have decided to go with four crew members.");
        getNextView();
    }

    private void crewSizeFive() {
        crewSize = 5;
        Group7SolarTrails.getShip().setNoCrew(5);
        this.console.println("You have decided to go with five crew members.");
        getNextView();
    }

    private void crewSizeSix() {
        crewSize = 6;
        Group7SolarTrails.getShip().setNoCrew(6);
        this.console.println("You have decided to go with six crew members.");
        getNextView();
    }

    private void crewSizeSeven() {
        crewSize = 7;
        Group7SolarTrails.getShip().setNoCrew(7);
        this.console.println("You have decided to go with seven crew members.");
        getNextView();
    }

    private void crewSizeEight() {
        crewSize = 8;
        Group7SolarTrails.getShip().setNoCrew(8);
        this.console.println("You have decided to go with eight crew members.");
        getNextView();
    }

    private void crewSizeNine() {
        crewSize = 9;
        Group7SolarTrails.getShip().setNoCrew(9);
        this.console.println("You have decided to go with nine crew members.");
        getNextView();
    }

    private void resetCrewOptions() {
        Group7SolarTrails.getShip().setNoCrew(1);
    }
    
    private void getNextView() {
        try {
            this.console.println("\n-----------------------------------------"
                                + "\n-------- Press Enter to Continue --------"
                                + "\n-----------------------------------------");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            ChooseCrewResearchSpecMenuView chooseCrewSpec = new ChooseCrewResearchSpecMenuView();
            chooseCrewSpec.begin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void previousMenu() {
        ChooseCrewMemberMenuView chooseCrew = new ChooseCrewMemberMenuView();
        chooseCrew.display();
    }
}
