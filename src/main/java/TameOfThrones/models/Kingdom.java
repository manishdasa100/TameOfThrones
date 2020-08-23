package TameOfThrones.models;

import java.util.List;
import java.util.HashMap;

public class Kingdom{

    private String kingdomName;
    private String emblem;
    private String msgReceived;
    private boolean kingWantsToBeRuller;
    private List<Kingdom> supportedKingdoms;

    public Kingdom() {}

    /***
     * Constructor
     * @param kingdomName
     * @param emblem
     * @param kingWantsToBeRuller
     */
    public Kingdom(String kingdomName, String emblem, String msgReceived, boolean kingWantsToBeRuller) {
        this.kingdomName = kingdomName;
        this.emblem = emblem;
        this.msgReceived = msgReceived;
        this.kingWantsToBeRuller = kingWantsToBeRuller;
    }

    public void setMsgReceived(String msgReceived) {
        this.msgReceived = msgReceived;
    }

    public void setSupportedKingdoms(List<Kingdom> supportedKingdoms) {
        this.supportedKingdoms = supportedKingdoms;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public String getMsgReceived() {
        return msgReceived;
    }

    public boolean ifKingWantsToBeRuler() {
        return kingWantsToBeRuller;
    }

    public String getEmblem() {
        return emblem;
    }

    /**
     * Method to check if the message received by the kingdom is correct
     * @param message
     * @param emblem
     * @return
     */
    public boolean isReceivedMessageCorrect() {
        int cypherKey = emblem.length();
        
        char[] msgCharArray = msgReceived.toCharArray();
        char[] emblemCharArray = emblem.toCharArray();

        // Modifying the emblemCharArray with cypher key
        for (int i = 0; i < emblemCharArray.length; i++) {
            emblemCharArray[i] = (char)(65 + ((emblemCharArray[i]+cypherKey)-65)%26);
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

    public String getAllSupporterNamesAsString() {
        String supporters = "";
        for (Kingdom kingdom : supportedKingdoms) {
            supporters = supporters + kingdom.getKingdomName() + " ";
        }

        return supporters;
    }

}