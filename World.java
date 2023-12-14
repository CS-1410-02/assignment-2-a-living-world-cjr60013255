import java.util.ArrayList;
import java.util.Scanner;

//import Creature;

public class World {
    static ArrayList<Creature> ecosystem = new ArrayList<>();
    public static void main(String[] args){
        //Scanner
        Scanner scanner = new Scanner(System.in);

        //create default world
        Creature newCreature = new Creature();
        ecosystem.add(newCreature);
        int currentDay = 0;

        while(true){//our iteration
            //our world stats
            int creatureCount = 0;
            String namesAndAges = "";
            currentDay++;

            for (int i = 0; i < ecosystem.size(); i++) {
                Creature currentCreature = ecosystem.get(i);
                currentCreature.dieRoll();
                currentCreature.damageRoll();
                currentCreature.healRoll();
                currentCreature.age++;
                if (currentCreature.life <= 0) {
                    ecosystem.remove(i);//remove because it is dead
                    i--; // Update the index
                }
                if (currentCreature.reproduceRoll() == true){
                    Creature babyCreature = currentCreature.copy();
                    ecosystem.add(babyCreature);
                }
                //gather the stats
                creatureCount++;
                namesAndAges = namesAndAges + "Name: " + currentCreature.getName() + " - Life:" + currentCreature.getLife() + " - Age: " + currentCreature.getAge() + "\n";
            
            }
            //output our stats
            System.out.print("Current day: " + currentDay + "\n" + namesAndAges);
            System.out.println("Press enter for next day");
            String temp = scanner.nextLine();
            

        }
    }
}