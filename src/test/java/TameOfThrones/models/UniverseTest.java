package TameOfThrones.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import TameOfThrones.GeekTrust;

import static org.junit.Assert.*;

public class UniverseTest{

    final boolean WANTS_TO_BE_RULER = true;
    final boolean DOES_NOT_WANT_TO_BE_RULER = false;

    @Test 
    public void thereIsaRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMERISCOMING", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "", WANTS_TO_BE_RULER));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "MOMAMVTMTMHTM", DOES_NOT_WANT_TO_BE_RULER));

        Universe universe = new Universe(kingdoms);
        
        assertNotNull(universe.getRuler());
        
    }

    @Test 
    public void thereIsNoRulerTest1() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMER IS COMING", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "", WANTS_TO_BE_RULER));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "MOMAMVTMQMHTM", DOES_NOT_WANT_TO_BE_RULER));

        Universe universe = new Universe(kingdoms);
        
        assertNull(universe.getRuler());
        
    }


    @Test 
    public void whoIsTheRulerTest() {
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("LAND", "PANDA", "FDIXXSOKKOFBBMU", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("WATER", "OCTOPUS", "SUMMERISCOMING", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("AIR", "OWL", "OWLAOWLBOWLC", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("SPACE", "GORILLA", "BNQVYTPSHS", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("FIRE", "DRAGON", "AJXGAMUTA", DOES_NOT_WANT_TO_BE_RULER));
        kingdoms.add(new Kingdom("ICE", "MAMMOTH", "", WANTS_TO_BE_RULER));

        Universe universe = new Universe(kingdoms);
        
        assertEquals("ICE", universe.getRuler().getKingdomName());
        
    }

}