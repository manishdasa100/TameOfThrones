package TameOfThrones.models;

import java.util.List;

public class Kingdom{

    private String kingdomName;
    private String emblem;
    private String msgReceived;
    private Boolean kingWantsToBeRuller;
    private List<Kingdom> supportedKingdoms;

    public Kingdom() {}

    /***
     * Constructor
     * @param kingdomName
     * @param emblem
     * @param kingWantsToBeRuller
     */
    public Kingdom(String kingdomName, String emblem, Boolean kingWantsToBeRuller) {
        this.kingdomName = kingdomName;
        this.emblem = emblem;
        this.kingWantsToBeRuller = kingWantsToBeRuller;
    }

    public void setMsgReceived(String msgReceived) {
        this.msgReceived = msgReceived;
    }

    public void setSupportedKingdoms(List<Kingdom> supportedKingdoms) {
        this.supportedKingdoms = supportedKingdoms;
    }

    public String getMsgReceived() {
        return msgReceived;
    }

    public Boolean ifKingWantsToBeRuler() {
        return kingWantsToBeRuller;
    }

    public String getEmblem() {
        return emblem;
    }

}