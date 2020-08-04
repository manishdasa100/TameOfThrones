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
    public void validFileProvided() throws IOException{
        
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\m.txt");
        assertEquals(GOOD_RESPONSE, getFileResponse.getResponse());
        
    }


    // @Test
    // public void validFileProvidedButFileContentIsEmpty() throws IOException{
    //     String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\q.txt");
    //     assertNotNull(content);
    //     assertEquals("File is empty.", content);
    // }


    @Test
    public void invalidFileProvided() throws IOException{
        String expectedMessage = "Invalid file. File must be a text file.";
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\n.bmp");
        assertEquals(BAD_RESPONSE, getFileResponse.getResponse());
        assertEquals(expectedMessage, getFileResponse.getMessage());
    }


    @Test
    public void fileNotInResources() throws IOException{
        String expectedMessage = "File provided in arguments not found! Please check the file name.";
        GetFileResponse getFileResponse = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\f.txt");
        assertEquals(BAD_RESPONSE, getFileResponse.getResponse());
        assertEquals(expectedMessage, getFileResponse.getMessage());
    }


    @Test
    public void analyzeMessageWithCorrectMsgTest() {
        String messageReceivedByKingdom = "MOMAMVTMTMHTM";
        String kingdomEmblem = "MAMMOTH";
        assertTrue(Helper.analyzeMessage(messageReceivedByKingdom, kingdomEmblem));
    }


    @Test
    public void analyzeMessageWithIncorrectMsgTest() {
        String messageReceivedByKingdom = "OWLAOWLBOWLC";
        String kingdomEmblem = "OWL";
        assertFalse(Helper.analyzeMessage(messageReceivedByKingdom, kingdomEmblem));
    }

    
    @Test
    public void analyzeMessageCircularTest() {
        String messageReceivedByKingdom = "ABC";
        String kingdomEmblem = "XYZ";
        assertTrue(Helper.analyzeMessage(messageReceivedByKingdom, kingdomEmblem));
    }


}