package TameOfThrones.models;

import java.util.HashMap;
import java.util.List;

import TameOfThrones.utils.Helper;

import java.util.ArrayList;

public class Universe{

    private List<Kingdom> kingdoms;
    private Kingdom ruler;

    public Universe() {}

    /***
     * Constructor
     * @param kingdoms
     */
    public Universe(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
        this.ruler = null;
    }

    public void setKingdoms(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }


    /**
     * THE FUNCTION SCANS THE LIST OF KINGDOMS IN THE UNIVERSE OF SOUTHEROS 
     * AND FIRST FINDS A POTENTIAL RULER AND SUPPORTERS FOR THAT RULER.
     * IF THE POTENTIAL RULER HAS ENOUGH SUPPORT THEN IT SETS IT AS THE RULER.
     */
    private void findRuler() {

        /* Traverse the list of kingdoms
           Find a potential ruler
           For each kingdom get the message sent
           get the emblem 
           Analyze the message 
           Add/ not add the kingdom to a list of supports
           
           if size of list of supports >= 3 then set the ruler
           
        */

        Kingdom potentialRuler = null;
        
        List<Kingdom> supporters = new ArrayList<Kingdom>();

        for (Kingdom kingdom : kingdoms) {
            if (kingdom.ifKingWantsToBeRuler()) potentialRuler = kingdom;

            String emblem = kingdom.getEmblem();
            String message = kingdom.getMsgReceived();

            if (message.length() > 0 && Helper.analyzeMessage(message, emblem)) supporters.add(kingdom);
        }

        if (potentialRuler != null && supporters.size() >= 3) {
            ruler = potentialRuler;
            ruler.setSupportedKingdoms(supporters);
        } 

    }


    /**
     * CALLS findRuler() AND RETURNS THE ASSINGNED RULER. 
     * @return ruler 
     */
    public Kingdom getRuler() {
        findRuler();
        return ruler;
    }
}