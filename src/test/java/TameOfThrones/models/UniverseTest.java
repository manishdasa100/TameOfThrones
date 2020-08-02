package TameOfThrones.models;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniverseTest{

    @Test 
    public void thereIsaRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", false));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMERISCOMING", false));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", false));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "", true));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", false));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "MOMAMVTMTMHTM", false));

        Universe universe = new Universe(kingdoms);
        
        assertNotNull(universe.getRuler());
        
    }

    @Test 
    public void thereIsNoRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", false));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMER IS COMING", false));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", false));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "", true));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", false));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "MOMAMVTMQMHTM", false));

        Universe universe = new Universe(kingdoms);
        
        assertNull(universe.getRuler());
        
    }


    @Test 
    public void whoIsTheRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", false));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMERISCOMING", false));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", false));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "BNQVYTPSHS", false));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", false));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "", true));

        Universe universe = new Universe(kingdoms);
        
        assertEquals("ICE", universe.getRuler().getKingdomName());
        
    }

}