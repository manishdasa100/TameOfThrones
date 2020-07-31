package TameOfThrones.utils;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

import TameOfThrones.utils.Helper;

import static org.junit.Assert.*;

public class HelperTest{

    @Test
    public void readFileFromResourcesTest() throws IOException{
        String expected = "air rozo\n"+
                          "land faijwjsoofamau\n"+
                          "ice sthststvsasos\n";
        String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\messageData.txt");
        assertNotNull(content);
        
    }

    @Test
    public void analyzeMessageWithCorrectMsgTest() {
        assertTrue(Helper.analyzeMessage("momamvtmtmhtm", "mammoth"));
    }


    @Test
    public void analyzeMessageWithIncorrectMsgTest() {
        assertFalse(Helper.analyzeMessage("owlaowlbowlc", "owl"));
    }

    
    @Test
    public void analyzeMessageCircularTest() {
        assertTrue(Helper.analyzeMessage("abc", "xyz"));
    }


}