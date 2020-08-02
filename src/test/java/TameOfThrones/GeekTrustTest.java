package TameOfThrones;


import org.junit.Test;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class GeekTrustTest {
    
    @Test
    public void getKingdomsTestWithNoRepeatedMessageTest() {

        String content = "AIR ROZO\n"+
                         "LAND FAIJWJSOOFAMAU\n"+
                         "ICE STHSTSTVSASOS";   
        
        assertEquals(4, GeekTrust.getKingdoms(content).size());

    }


    @Test
    public void getKingdomsTestWithRepeatedMessageTest() {
        String content = "AIR ROZO\n"+
                         "AIR ROZO\n"+
                         "AIR ROZO\n"+
                         "WATER BNBNN";  
                        
        assertEquals(3, GeekTrust.getKingdoms(content).size());                 
    }


    @Test
    public void getKingdomsTestWithoutMessageTest() {
        String content = "";  
        assertEquals(1, GeekTrust.getKingdoms(content).size());
    }
}