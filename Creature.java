import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
public class Creature {
    int life = 100;
    String nameOf = name();
    int hungerLevel = 0;

   public Creature (int life, String nameOf, int hungerLevel){
        this.life = life;
        this.nameOf = nameOf;
        this.hungerLevel = hungerLevel;

    }

    void die(){}
    void reproduce(){}

    static int number() {
        // Creating an instance of the Random class
        Random random = new Random();
        // Generating a random number between 1 and 3000
        return random.nextInt(3000) + 1;
    }

    String getName (){
        return this.nameOf;
    }
    int getLife (){
        return this.life;
    }
    public int hungerLevel (){
        return this.hungerLevel;
    }

    public static String[] FileToArray () {
        String fileName = "name.txt"; 
        String[] namefailsafe = {"UnobtainableIAmError"};

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            return content.split(",");

        } catch (IOException e) {
            e.printStackTrace();
            return namefailsafe;
        }
    }

    public static String name (){
        String[] naes = FileToArray();
        int number = number() - 1;
        if(naes.length <= 1){
            return "IAmError";
        }else{
            return naes[number];
        }
    }
 
}
