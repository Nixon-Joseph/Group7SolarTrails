/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.solarTrails.view;

import java.util.Scanner;

/**
 *
 * @author Nixon-Joseph
 */
public class AlienObjectMenuView extends View{

        public AlienObjectMenuView() {
            super("\n"
        + "\n-----------------------------------"
        + "\n | Alien Object menu"
        + "\n | Please select an option."
        + "\n-----------------------------------"
        + "\nR - Research Item"
        + "\nL - Leave for Earth"
        + "\n-----------------------------------");
        }
    
        @Override
        public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        switch (choice) {
            case 'R': // Research Object
                this.chooseResearch();
                break;
            case 'L': // Leave Object
                this.chooseLeaveObject();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                getInput();
                break;
        } return false;
    }
    
    private void chooseResearch() {
        System.out.println("Chose Research, congrats!");
    }
    
    private void chooseLeaveObject() {
        System.out.println("Chose leaving, congrats! hope you have enough food and fuel");
    }
}