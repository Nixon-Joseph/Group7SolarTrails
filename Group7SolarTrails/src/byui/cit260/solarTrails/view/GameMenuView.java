/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.solarTrails.view;

import byui.cit260.solarTrails.control.GameControl;
import byui.cit260.solarTrails.model.Game;
import byui.cit260.solarTrails.model.Map;
import group7solartrails.Group7SolarTrails;
import static group7solartrails.Group7SolarTrails.crewList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hiatt-Adam
 */
public class GameMenuView extends View{
        GameMenuView gameMenuView;
        
    public GameMenuView() {
        
       super("\n"
            + "\n---------------------------------------"
            + "\n | Game Menu Options"
            + "\n---------------------------------------"
            + "\nR - Status Report"
            + "\nM - Map"
            + "\nI - Inventory"
            + "\nC - Create an Item"
            + "\nS - Ship"
            + "\nH - SickBay - Heal your crew."
            + "\nF - Rations"
            + "\nA - Save your current progress."
            + "\nL - Load another game or previous progress."
            + "\nD - Go Back to the previous menu"
            + "\nE - Exit the game."
            + "\n-----------------------------------");

    }
    public double distance = 0;
    public double travelTime = 0;
    
        public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        
        switch (choice) {
            case 'R': // create and start a new game
                this.chooseStatusReport();
                break;
            case 'M': // get and start an existing game
                this.chooseMap();
                break;
            case 'I': // display the help menu
                this.chooseInventory();
                break;
            case 'C': // create and start a new game
                this.chooseSynthesizer();
                break;
            case 'S': // get and start an existing game
                this.chooseShip();
                break;
            case 'H': // display the help menu
                this.chooseSickBay();
                break;
            case 'F': // create and start a new game
                this.chooseRations();
                break;
            case 'A': // get and start an existing game
                this.chooseSave();
                break;
            case 'L': // display the help menu
                this.chooseLoad();
                break;
            case 'D': // Previous Menu
                this.previousMenu();
                break;
            case 'E': // Exit the program
                System.exit(0);
                break;
            default:
                try {
                this.console.println("\n*** Invalid selection *** "
                                   + "\nPrease enter to try again");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
        } catch (IOException e) {
        e.printStackTrace();
        }
                break;
        } return false;
    }
        
       @Override
       public String getInput() {
       boolean valid = false; // indicates if the input has been retrieved
       String value = null;
       
       
       while(!valid) { // while a valid input has not been retreved
        try{
                      
           // get the input from the keyboard and trim off the blanks
           value = this.keyboard.readLine();
           value = value.trim();
           value = value.toUpperCase();
           
           // if the input is invalid (less than 3 character)
           if (value.length() < 0) {
               ErrorView.display(this.getClass().getName(),
                       "Invalid path - Please try again.");
               continue; // and repeat again
           }
           break; // exit repetition
       }
       catch (Exception e) {
               ErrorView.display(this.getClass().getName(),
                       "Error reading input: " + e.getMessage());
               return null;
               }
       
} return value; // return the input  
}

    private void chooseStatusReport() {
        
        // Choose Status Report
            distance = abs(Map.PlanetDist.Mercury - Group7SolarTrails.getLocation().getCurrentLocation());
            travelTime = ((distance/Group7SolarTrails.getEngine().getMaxSpeed())/24);
        this.console.println("The current status of your ship is:");
        this.console.println("Your ship is at " + Group7SolarTrails.getShip().getCurrentShipDurability() +
                " of " + Group7SolarTrails.getShip().getMaxShipDurability() + " durability");
        this.console.println("You are currently " + distance + "merdian from Mercury.");
        this.console.println("This is approximately " + travelTime + "days remaining.");
        this.console.println("Your crews health status is " + Group7SolarTrails.crewList);
    }

    private void chooseMap() {
        MapChooseDestinationView mapView = new MapChooseDestinationView();
        mapView.display();
    }

    private void chooseInventory() {
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }
    private void chooseSynthesizer() {
        // Choose Synthesizer
    }

    private void chooseShip() {
        // Choose Ship
    }

    private void chooseSickBay() {
        // Choose SickBay
    }

    private void chooseRations() {
        // Choose Rations
    }

    private void chooseSave() {
        // Choose Save
        this.console.println("\n\nEnter the file path for file where the game "
                            + "is to be saved.");
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(Group7SolarTrails.getCurrentGame(), filePath);
        }catch (Exception ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }

    private void chooseLoad() {
        // Choose Load
        this.console.println("\n\nEnter the file path for the file where the game "
                            + "is to be loaded from.");
        
        String filePath = this.getInput();
        
        try {
            GameControl.loadGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void previousMenu() {
            try {
                // Choose Previous Menu or Go back to game
                gameMenuView.keyboard.close();
            } catch (IOException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}

