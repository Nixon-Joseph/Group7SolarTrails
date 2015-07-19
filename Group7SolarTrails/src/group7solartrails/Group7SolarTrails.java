/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7solartrails;

import byui.cit260.solarTrails.model.*;
import byui.cit260.solarTrails.view.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiatt-Adam
 */
public class Group7SolarTrails {

    /**
     * @param args the command line arguments
     */
    
    private static Game currentGame = null;
    private static Player player = null;
    List charList = new ArrayList<>();
    private static Ship ship = null;
    public static Engine engine = null;
    private static Crew crew = null;
    public static ScientistSpecialization scienceSpec = null;

    public static ScientistSpecialization getScienceSpec() {
        return scienceSpec;
    }

    public static void setScienceSpec(ScientistSpecialization scienceSpec) {
        Group7SolarTrails.scienceSpec = scienceSpec;
    }

    public static Crew getCrew() {
        return crew;
    }

    public static void setCrew(Crew crew) {
        Group7SolarTrails.crew = crew;
    }

    public static Engine getEngine() {
        return engine;
    }

    public static void setEngine(Engine engine) {
        Group7SolarTrails.engine = engine;
    }
    private static InventoryItem inventory = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Group7SolarTrails.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Group7SolarTrails.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public List getCharList() {
        return charList;
    }

    public void setCharList(List charList) {
        this.charList = charList;
    }

    public static void setInFile(BufferedReader inFile) {
        Group7SolarTrails.inFile = inFile;
    }
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Group7SolarTrails.currentGame = currentGame;
    }

    public static Ship getShip() {
        return ship;
    }

    public static void setShip(Ship ship) {
        Group7SolarTrails.ship = ship;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Group7SolarTrails.player = player;
    }    

    public static InventoryItem getInventory() {
        return inventory;
    }

    public static void setInventory(InventoryItem inventory) {
        Group7SolarTrails.inventory = inventory;
    }
    
    public static void setCrew(int maxCrew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
    public static void main(String[] args) {
        try {
            // open character stream files for end user input and output
            Group7SolarTrails.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            Group7SolarTrails.outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            Group7SolarTrails.logFile = new PrintWriter(filePath);

        // create StartProgramView and start the program
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
        
        } catch (Throwable e) {
        System.err.println("Exception: " + e.toString() +
                            "\nCause: " + e.getCause() + 
                            "\nMessage: " + e.getMessage());
        e.printStackTrace();
    }
    finally {
            try {
                if (Group7SolarTrails.inFile != null)
                    Group7SolarTrails.inFile.close();
                
                if (Group7SolarTrails.outFile != null)
                    Group7SolarTrails.outFile.close();
                
                if (Group7SolarTrails.logFile != null)
                    Group7SolarTrails.logFile.close();
                
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }
}
