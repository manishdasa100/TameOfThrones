package TameOfThrones.utils;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

import TameOfThrones.utils.Helper;

import static org.junit.Assert.*;

public class HelperTest{

    @Test
    public void validFileProvided() throws IOException{
        String expected = "LAND FDIXXSOKKOFBBMU\n"+
                          "ICE MOMAMVTMTMHTM\n"+
                          "WATER SUMMER\n"+
                          "AIR OWLAOWLBOWLC";
        String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\m.txt");
        assertNotNull(content);
        
    }


    // @Test
    // public void validFileProvidedButFileContentIsEmpty() throws IOException{
    //     String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\q.txt");
    //     assertNotNull(content);
    //     assertEquals("File is empty.", content);
    // }


    @Test
    public void invalidFileProvided() throws IOException{
        String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\n.bmp");
        assertEquals("Invalid file. File must be a text file.", content);
    }


    @Test
    public void fileNotInResources() throws IOException{
        String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\f.txt");
        assertEquals("File provided in arguments not found! Please check the file name.", content);
    }


    @Test
    public void analyzeMessageWithCorrectMsgTest() {
        assertTrue(Helper.analyzeMessage("MOMAMVTMTMHTM", "MAMMOTH"));
    }


    @Test
    public void analyzeMessageWithIncorrectMsgTest() {
        assertFalse(Helper.analyzeMessage("OWLAOWLBOWLC", "OWL"));
    }

    
    @Test
    public void analyzeMessageCircularTest() {
        assertTrue(Helper.analyzeMessage("ABC", "XYZ"));
    }


}