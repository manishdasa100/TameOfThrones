package TameOfThrones.utils;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

import TameOfThrones.excahnges.GetFileResponse;
import TameOfThrones.utils.Helper;

import static org.junit.Assert.*;

public class HelperTest{

    final String GOOD_RESPONSE = "GOOD";
    final String BAD_RESPONSE = "BAD";

    @Test
    public void validFileProvidedTest() throws IOException {
        
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("src/main/resources/m.txt");
        assertEquals(GOOD_RESPONSE, getFileResponse.getResponse());
        
    }


    @Test
    public void invalidFileProvidedTest() throws IOException{
        String expectedMessage = "Invalid file. File must be a text file.";
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("src/main/resources/n.bmp");
        assertEquals(BAD_RESPONSE, getFileResponse.getResponse());
        assertEquals(expectedMessage, getFileResponse.getMessage());
    }


    @Test
    public void fileNotInResourcesTest() throws IOException {
        String expectedMessage = "File provided in arguments not found! Please check the file name.";
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("src/main/resources/f.txt");
        assertEquals(BAD_RESPONSE, getFileResponse.getResponse());
        assertEquals(expectedMessage, getFileResponse.getMessage());
    }


    @Test
    public void parseKingdomsWithNoRepeatedMessageTest() {

        String content = "AIR ROZO\n"+
                         "LAND FAIJWJSOOFAMAU\n"+
                         "ICE STHSTSTVSASOS";   
        
        assertEquals(4, Helper.parseKingdoms(content).size());

    }


    @Test
    public void parseKingdomsWithRepeatedMessageTest() {
        String content = "AIR ROZO\n"+
                         "AIR ROZO\n"+
                         "AIR ROZO\n"+
                         "WATER BNBNN";  
                        
        assertEquals(3, Helper.parseKingdoms(content).size());                 
    }


    @Test
    public void parseKingdomsWithoutMessageTest() {
        String content = "";  
        assertEquals(1, Helper.parseKingdoms(content).size());
    }


}