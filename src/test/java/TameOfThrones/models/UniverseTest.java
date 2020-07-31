package TameOfThrones.models;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniverseTest{

    @Test
    public void analyzeMessageWithCorrectMsgTest() {
        Universe univ = new Universe();
        assertTrue(univ.analyzeMessage("faijwjsoofamau", "panda"));
    }


    @Test
    public void analyzeMessageWithIncorrectMsgTest() {
        Universe univ = new Universe();
        assertFalse(univ.analyzeMessage("jnjnsjni", "owl"));
    }

}