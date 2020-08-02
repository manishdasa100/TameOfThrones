package TameOfThrones.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import com.google.common.io.Files;

public class Helper{

    private Helper() { /*Singleton*/}

    /**
     * Helper method to read contents of a file and return the content as string
     * @param filename
     * @return String content of the file
     */
    public static String resolveFileFromResources(String filename) throws IOException {

        if (!Files.getFileExtension(filename).equals("txt")) return "Invalid file. File must be a text file.";

        String content = "";
        try{
            InputStream inputStream = new FileInputStream(new File(filename));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            content = new String(buffer, StandardCharsets.UTF_8);

        } catch(IOException exception) {
            content = "File provided in arguments not found! Please check the file name.";
        }
        
        return content;
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