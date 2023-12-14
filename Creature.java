import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.Arrays;
import java.util.Random;
public class Creature {
    //Default values
    int life = 100;
    String nameOf = reName();
    int hungerLevel = 0;
    int reproduceOneIn = 5;
    int dieOneIn = 10;
    int damageChance = 10;
    int healChance = 2;
    int findFoodChance = 3;
    int age = 0;

   public Creature (int life, String nameOf, int hungerLevel, int reproduceOneIn, int dieOneIn, 
   int damageChance, int healChance, int findFoodChance, int age){
        this.life = life;
        this.nameOf = nameOf;
        this.hungerLevel = hungerLevel;
        this.reproduceOneIn = reproduceOneIn;
        this.dieOneIn = dieOneIn;
        this.damageChance = damageChance;
        this.healChance = healChance;
        this.age = age;
    }
    // Method to create a copy of a Creature
    Creature copy() {
        Creature newCreature = new Creature(100, reName(), 0, this.reproduceOneIn, this.dieOneIn, this.damageChance, this.healChance, 3, -1);
        return newCreature;
    }
    public Creature() {
        // Using 'this' keyword to call the main constructor with default values
        this(100, reName(), 0, 5, 100, 10, 2, 3, 0);
    }
    
    //rolling chance classes
    void dieRoll(){
        if((number(this.dieOneIn)) == 1){
            this.life = 0;
        }
    }
    void foodRoll(){
        if((number(this.dieOneIn)) == 1){
            this.life = 0;
        }
    }
    void damageRoll(){
        if((number(this.dieOneIn)) == 1){
            this.life -= 5;
        }
        this.life -= (5*this.hungerLevel);
    }
     void healRoll(){
        if((number(this.dieOneIn)) == 1){
            if(this.life <= 95){
                this.life += 5;
            }else{
                this.life = 100;
            }
        }
    }
    Boolean reproduceRoll(){
        if((number(this.reproduceOneIn)) == 1){
            return true;
        }else{
            return false;
        }
    }

    //random number for rolling
    static int number(int max) {
        // Creating an instance of the Random class
        Random random = new Random();
        // Generating a random number between 1 and 3000
        return random.nextInt(max) + 1;
    }

    //return properties classes
    String getName (){
        return this.nameOf;
    }
    int getLife (){
        return this.life;
    }
    int getAge (){
        return this.age;
    }
    void age (){
        this.age++;
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

    public static String reName (){
        String[] naes = FileToArray();
        int number = number(3000) - 1;
        if(naes.length <= 1){
            return "IAmError";
        }else{
            return naes[number];
        }
    }
 
}
