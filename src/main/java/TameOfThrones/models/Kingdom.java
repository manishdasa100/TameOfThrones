package TameOfThrones.models;

import java.util.List;

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

    public String getAllSupporterNamesAsString() {
        String supporters = "";
        for (Kingdom kingdom : supportedKingdoms) {
            supporters = supporters + kingdom.getKingdomName() + " ";
        }

        return supporters;
    }

}