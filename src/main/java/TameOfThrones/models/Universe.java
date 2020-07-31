package TameOfThrones.models;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Universe{

    List<Kingdom> kingdoms;
    Kingdom ruler;

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

            if (message != null && analyzeMessage(message, emblem)) supporters.add(kingdom);
        }

        if (potentialRuler != null && supporters.size() >= 3) ruler = potentialRuler; 

    }

    public boolean analyzeMessage(String message, String emblem) {
       
        int cypherKey = emblem.length();
        
        char[] msgCharArray = message.toCharArray();
        char[] emblemCharArray = emblem.toCharArray();

        // Modifying the emblemCharArray with cypher key
        for (int i = 0; i < emblemCharArray.length; i++) {
            emblemCharArray[i] = (char)(emblemCharArray[i]+cypherKey);
        }

        HashMap<Character, Integer> msgFreqMap = new HashMap<Character, Integer>();

        // Creating a freq map of message characters
        for (char c : msgCharArray) {
            msgFreqMap.put(c, msgFreqMap.getOrDefault(c, 0) + 1);
        }

        // Checking if the characters in emblem are present in the message
        for (char c : emblemCharArray) {
            if (!msgFreqMap.containsKey(c)) {
                return false;
            } 

            int freq = msgFreqMap.get(c)-1;
            if (freq == 0) msgFreqMap.remove(c);
            else msgFreqMap.put(c, freq);
        }

        return true;
    }

    public Kingdom getRuler() {
        findRuler();
        return ruler;
    }
}