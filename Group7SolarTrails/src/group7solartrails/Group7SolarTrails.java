/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7solartrails;

import byui.cit260.solarTrails.model.Player;
import byui.cit260.solarTrails.model.Character;

/**
 *
 * @author Hiatt-Adam
 */
public class Group7SolarTrails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Player playerOne = new Player();
       
       playerOne.setName("Space Captain");
       playerOne.setBestScore(200);
       
       String playerInfo = playerOne.toString();
       System.out.println(playerInfo);
       
       Character character = new Character();
       
       character.setDescription("A super awesome dude!");
       
       String characterInfo = character.toString();
       System.out.println(characterInfo);
    }
    
}