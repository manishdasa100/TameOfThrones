/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TameOfThrones;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import TameOfThrones.models.Kingdom;
import TameOfThrones.models.Universe;
import TameOfThrones.utils.Helper;

public class GeekTrust {
    public static void main(String[] args) throws IOException{
        
        String content = Helper.resolveFileFromResources("D:\\manish\\create\\java\\TameOfThrones\\src\\main\\resources\\messageData.txt");

        String[] entries = content.split("\n");

        
        
        List<Kingdom> kingdoms = new ArrayList<Kingdom>();
        kingdoms.add(new Kingdom("land", "panda", "fdixxsokkofbbmu", false));
        kingdoms.add(new Kingdom("water", "octopus", "summer is coming", false));
        kingdoms.add(new Kingdom("air", "owl", "owlaowlbowlc", false));
        kingdoms.add(new Kingdom("space", "gorilla", "bnqvytpshs", false));
        kingdoms.add(new Kingdom("fire", "dragon", "ajxgamuta", false));
        kingdoms.add(new Kingdom("ice", "mammoth", "", true));

        Universe southeros = new Universe(kingdoms);

        Kingdom ruler = southeros.getRuler();

        if (ruler != null) {

            String supporters = "";
            for (Kingdom kingdom : ruler.getSupporteKingdoms()) {
                supporters = supporters + kingdom.getKingdomName() + " ";
            } 

            //System.out.println(ruler.getKingdomName() + " " + supporters);
        } else {
            System.out.println("NONE");
        } 
    }
}
