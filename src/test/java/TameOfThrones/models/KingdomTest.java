package TameOfThrones.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class KingdomTest{

    @Test
    public void correctMessageReceivedByKingdomTest() {

        String messageReceivedByKingdom = "MOMAMVTMTMHTM";
        String kingdomEmblem = "MAMMOTH";

        Kingdom anyKingdom = new Kingdom("ICE", kingdomEmblem, messageReceivedByKingdom, false);

        assertTrue(anyKingdom.isReceivedMessageCorrect());

        messageReceivedByKingdom = "EWZSSRKGAQAT";
        kingdomEmblem = "ZUMBO";
        
        anyKingdom = new Kingdom("LAND", kingdomEmblem, messageReceivedByKingdom, false);

        assertTrue(anyKingdom.isReceivedMessageCorrect());
    }


    @Test
    public void incorrectMessageReceivedByKingdomTest() {
        String messageReceivedByKingdom = "OWLAOWLBOWLC";
        String kingdomEmblem = "OWL";

        Kingdom anyKingdom = new Kingdom("AIR", kingdomEmblem, messageReceivedByKingdom, false);

        assertFalse(anyKingdom.isReceivedMessageCorrect());
    }

}