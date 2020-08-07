package TameOfThrones.utils;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.Files;

import TameOfThrones.excahnges.GetFileResponse;
import TameOfThrones.models.Kingdom;

public class Helper{

    private Helper() { /*Singleton*/}

    /**
     * Helper method to read contents of a file and return the content as string
     * @param filePath
     * @return String content of the file
     */
    public static GetFileResponse resolveFileFromResources(String filePath) throws IOException {

        final String BAD_RESPONSE = "BAD";
        final String GOOD_RESPONSE = "GOOD";

        GetFileResponse getFileResponse = new GetFileResponse();

        // IF THE FILE PROVIDED IN THE AGRS IS NOT A TEXT FILE
        if (!Files.getFileExtension(filePath).equals("txt")) {
            String message = "Invalid file. File must be a text file.";
            getFileResponse.setResponse(BAD_RESPONSE);
            getFileResponse.setMessage(message);
            return getFileResponse;
        }

        
        try{

            InputStream inputStream = new FileInputStream(new File(Paths.get(filePath).toUri()));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            String fileContent = new String(buffer, StandardCharsets.UTF_8);

            getFileResponse.setResponse(GOOD_RESPONSE);
            getFileResponse.setFileContent(fileContent);

        } catch(IOException exception) {
            
            String message = "File provided in arguments not found! Please check the file name.";
            getFileResponse.setResponse(BAD_RESPONSE);
            getFileResponse.setMessage(message);
            
        }
        
        return getFileResponse;
    }


    /**
     * THIS FUNCTION CREATES AND RETURNS A LIST OF KINGDOM OBJECTS FROM FILE fileCONTENT
     * @param fileContent FILE fileCONTENT AS STRING
     * @return LIST OF KINGDOMS
     */

    public static List<Kingdom> parseKingdoms(String fileContent) {

        final boolean WANTS_TO_BE_RULER = true;
        final boolean DOES_NOT_WANT_TO_BE_RULER = false;

        List<Kingdom> kingdoms = new ArrayList<Kingdom>();

        // ADDING THE POTENTIAL RULER IN THE LIST OF KINGDOMS
        Kingdom potentialRuler = new Kingdom("SPACE", "GORILLA", "", WANTS_TO_BE_RULER);
        kingdoms.add(potentialRuler);

        if (fileContent.isEmpty()) return kingdoms;

        // CREATING A MAPPING KINGDOM -> EMBLEM
        HashMap<String, String> kingdomToEmblemMap = new HashMap<>();
        kingdomToEmblemMap.put("LAND", "PANDA");
        kingdomToEmblemMap.put("WATER", "OCTOPUS");
        kingdomToEmblemMap.put("AIR", "OWL");
        kingdomToEmblemMap.put("SPACE", "GORILLA");
        kingdomToEmblemMap.put("FIRE", "DRAGON");
        kingdomToEmblemMap.put("ICE", "MAMMOTH");

        
        String[] rows = fileContent.split("\n");

        HashSet<String> register = new HashSet<>();

        // CREATING A LIST OF KINGDOMS FROM THE FILE fileCONTENT
        for (int rowNumber = 0; rowNumber < rows.length; rowNumber++) {
            
            String[] rowParts = rows[rowNumber].split(" ", 2);

            String kingdomName = rowParts[0];
            String messageReceivedByTheKingdom = rowParts[1];

            String kingdomEmblem = kingdomToEmblemMap.get(kingdomName);

            if (!register.contains(kingdomName)) {
                kingdoms.add(new Kingdom(kingdomName, kingdomEmblem, messageReceivedByTheKingdom, DOES_NOT_WANT_TO_BE_RULER));
                register.add(kingdomName);
            }    
        }

        return kingdoms;
    
    }


    /**
     * Helper method to check if the encoded emblem is present in the message
     * @param message
     * @param emblem
     * @return
     */
    public static boolean analyzeMessage(String message, String emblem) {
        int cypherKey = emblem.length();
        
        char[] msgCharArray = message.toCharArray();
        char[] emblemCharArray = emblem.toCharArray();

        // Modifying the emblemCharArray with cypher key
        for (int i = 0; i < emblemCharArray.length; i++) {
            emblemCharArray[i] = (char)(65 + ((emblemCharArray[i]+cypherKey)-65)%26);
        }

        HashMap<Character, Integer> msgFreqMap = new HashMap<Character, Integer>();

        // Creating a freq map of message characters
        for (char c : msgCharArray) {
            msgFreqMap.put(c, msgFreqMap.getOrDefault(c, 0) + 1);
        }

        // Checking if the characters in emblem are present in the message
        for (char c : emblemCharArray) {
            if (!msgFreqMap.containsKey(c)) {
                return false;
            } 

            int freq = msgFreqMap.get(c)-1;
            if (freq == 0) msgFreqMap.remove(c);
            else msgFreqMap.put(c, freq);
        }

        return true;
    }

}