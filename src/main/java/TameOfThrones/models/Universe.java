package TameOfThrones.models;

import java.util.HashMap;
import java.util.HashSet;
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

        Kingdom potentialRuler = null;
        
        List<Kingdom> supporters = new ArrayList<Kingdom>();

        for (Kingdom kingdom : kingdoms) {
            if (kingdom.ifKingWantsToBeRuler()) potentialRuler = kingdom;

            if (kingdom.isReceivedMessageCorrect()) supporters.add(kingdom);
        }

        if (potentialRuler != null && supporters.size() >= 3) {
            ruler = potentialRuler;
            ruler.setSupportedKingdoms(supporters);
        } 

    }


    /**
     * FINDS THE RULER AND RETURNS IT. RETURNS NULL IF THERE IS NO RULER 
     * @return ruler 
     */
    public Kingdom getRuler() {
        findRuler();
        return ruler;
    }
}