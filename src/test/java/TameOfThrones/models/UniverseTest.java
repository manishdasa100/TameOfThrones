package TameOfThrones.models;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniverseTest{

    @Test 
    public void thereIsaRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("land", "panda", "fdixxsokkofbbmu", false));
        kingdoms.add(new Kingdom("water", "octopus", "summer is coming", false));
        kingdoms.add(new Kingdom("air", "owl", "owlaowlbowlc", false));
        kingdoms.add(new Kingdom("space", "gorilla", "", true));
        kingdoms.add(new Kingdom("fire", "dragon", "ajxgamuta", false));
        kingdoms.add(new Kingdom("ice", "mammoth", "momamvtmtmhtm", false));

        Universe universe = new Universe(kingdoms);
        
        assertNotNull(universe.getRuler());
        
    }

    @Test 
    public void thereIsNoRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("land", "panda", "fdixxsokkofbbmu", false));
        kingdoms.add(new Kingdom("water", "octopus", "summer is coming", false));
        kingdoms.add(new Kingdom("air", "owl", "owlaowlbowlc", false));
        kingdoms.add(new Kingdom("space", "gorilla", "", true));
        kingdoms.add(new Kingdom("fire", "dragon", "ajxgamuta", false));
        kingdoms.add(new Kingdom("ice", "mammoth", "momamvtmqmhtm", false));

        Universe universe = new Universe(kingdoms);
        
        assertNull(universe.getRuler());
        
    }


    @Test 
    public void whoIsTheRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("land", "panda", "fdixxsokkofbbmu", false));
        kingdoms.add(new Kingdom("water", "octopus", "summer is coming", false));
        kingdoms.add(new Kingdom("air", "owl", "owlaowlbowlc", false));
        kingdoms.add(new Kingdom("space", "gorilla", "bnqvytpshs", false));
        kingdoms.add(new Kingdom("fire", "dragon", "ajxgamuta", false));
        kingdoms.add(new Kingdom("ice", "mammoth", "", true));

        Universe universe = new Universe(kingdoms);
        
        assertEquals("ice", universe.getRuler().getKingdomName());
        
    }

}