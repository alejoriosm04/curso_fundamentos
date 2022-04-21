import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    public static ArrayList<Ubication> ubications = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------");
        slowPrint("Welcome to Alexandria Zombies database. \n");
        slowPrint("This software was created to save all \n");
        slowPrint("the information about Zombies and Locations around the community. \n");
        slowPrint("This information will be useful for \n");
        slowPrint("the Alexandria major, Rick and his partners. \n");

        mostrarMenu();
    }
    public static void mostrarMenu() {
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("-----------------------------------------------------");
            System.out.println("0. Close the system.");
            System.out.println("1. Enter info about Zombie.");
            System.out.println("2. Show the list of stored Zombies.");
            System.out.println("3. Show amount Zombies created.");
            System.out.println("4. Show the Zombies that contain O+ or AB+.");
            System.out.println("5. Show Zombies that were born after 2000.");
            System.out.println("6. Drop a bomb in Alexandria.");
            System.out.println("7. Enter info about ubication.");
            System.out.println("8. Show all stored ubication.");
            System.out.println("9. Show info about the safest ubication in the city.");
            System.out.println("10. Show ubications in distance order.");
            System.out.println("11. Show a random sentence.");
            System.out.println("12. How many infected people around Alexandria?");
            System.out.println("-----------------------------------------------------");

            System.out.print("Enter a number: ");
            int num = scan.nextInt();
            if(num == 0) {
                break;
            }
            switch(num){

                case 1:
                    System.out.print("Enter Zombie`s name: "); String nom = scan.next();
                    System.out.print("Enter Zombie`s health: "); int health = scan.nextInt();
                    System.out.print("Enter year of birth: "); int year = scan.nextInt();
                    System.out.print("Enter blood type (A+, A-, B+, B-, AB+, AB-, O+, O-): "); String bloodType = scan.next(); bloodType = bloodType.toUpperCase();
                    System.out.print("Enter amount infected people: "); int infectedPeople = scan.nextInt();
                    zombies.add(new Zombie(nom, health, year, bloodType, infectedPeople));
                    break;

                case 2:
                    for (int i = 0; i < zombies.size(); i++) {
                        zombieInformation(i);
                    }
                    break;

                case 3:
                    System.out.println("The amount of Zombies is: " + zombies.size());
                    break;

                case 4:
                    System.out.println("Blood type O+ or AB+:");
                    for(int i = 0; i < zombies.size(); i++){
                        if(zombies.get(i).getBloodType().equals("O+") || zombies.get(i).getBloodType().equals("AB+")){
                            zombieInformation(i);
                        }
                    }
                    break;

                case 5:
                    System.out.println("All Millennials Zombies:");
                    int count = 0;
                    for(int i=0;i<zombies.size();i++){
                        if(zombies.get(i).getYear()>2000){
                            zombieInformation(i); count++;
                        }
                        if(count == 0){
                            System.out.println("There are not Millennials Zombies");
                        }
                    }
                    break;

                case 6:
                    slowPrint("'BOOOM 🔥🔥🔥[TNT]'... The boom has been dropped");
                    slowPrint("\nThe health of the Zombies will decrease by half");
                    for(int i = 0; i < zombies.size(); i++) {
                        System.out.println(zombies.get(i).getNameZ() + " / " + zombies.get(i).getHealth() + " --> " + zombies.get(i).getHealth() / 2 + " / " + zombies.get(i).getYear() + " / " + zombies.get(i).getBloodType());
                        zombies.get(i).setHealth(zombies.get(i).getHealth() / 2);
                        if (zombies.get(i).getHealth() == 0) {
                            System.out.println(zombies.get(i).getNameZ() + " has dead (✖╭╮✖)");
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter Ubication Name: "); String nameU = scan.next();
                    System.out.print("Enter Distance: "); float distance = scan.nextFloat();
                    System.out.print("Enter amount of Zombies in the Ubication: "); int numberZombies = scan.nextInt();

                    ubications.add(new Ubication(nameU, distance, numberZombies));
                    break;

                case 8:
                    for (int i = 0; i < ubications.size(); i++) {
                        ubicationInformation(i);
                    }
                    break;

                case 9:
                    int smallest = ubications.get(0).getNumberZombies();
                    int position = 0;
                    for(int i = 1; i < ubications.size(); i++){
                        if(ubications.get(i).getNumberZombies() < smallest) {
                            smallest = ubications.get(i).getNumberZombies();
                            position = i;
                        }
                    }
                    System.out.println("The Safest Ubication is: "); ubicationInformation(position);
                    break;

                case 10:
                    int n = ubications.size(); Ubication memory;
                    for(int i = 1; i < n; i++){
                        for(int j = 0; j < n-1; j++){
                            if(ubications.get(j).getDistance() > ubications.get(j+1).getDistance()){
                                memory = ubications.get(j);
                                ubications.set(j, ubications.get(j+1));
                                ubications.set(j+1, memory);
                            }
                        }
                    }
                    System.out.println("Sort Ubications :");
                    for(int i = 0; i < ubications.size(); i++){
                        ubicationInformation(i);
                    }
                    break;

                case 11:
                    Random ram = new Random();
                    int value = ram.nextInt(5);
                    phrasesZombies(value);
                    break;

                case 12:
                    int total = 0;
                    for(int i = 0; i<zombies.size(); i++){
                        total += zombies.get(i).getInfectedPeople();
                    }
                    System.out.println("The total infected people around Alexandria are: " + total);
                    break;
            }
        }
        System.out.println("Exit. The Walking Dead");
    }

    public static void ubicationInformation(int i) {
        System.out.println(ubications.get(i).getNameU() + " / " + ubications.get(i).getDistance() + "m" + " / " + ubications.get(i).getNumberZombies() + " Zombies" + zombies.get(i).getInfectedPeople() + " infected people.");
    }
    public static void zombieInformation(int i) {
        System.out.println(zombies.get(i).getNameZ() + " / " + zombies.get(i).getHealth() + " HP" + " / " + zombies.get(i).getYear() + " / " + "RH: " + zombies.get(i).getBloodType());
    }
    public static void phrasesZombies(int i) {
        switch(i) {
            case 0:
                System.out.println("\nBrain that I see, brain that I eat");
                break;
            case 1:
                System.out.println("\nBetter to be alone that with a bad partner");
                break;
            case 2:
                System.out.println("\nAll we have a secret that we don't want to come to light");
                break;
            case 3:
                System.out.println("\nZombies are the only people who will love you for your brain");
                break;
            case 4:
                System.out.println("\nEnjoy life, it can end in a blink of eyes");
                break;
        }
    }

    public static void slowPrint(String output) {
        for (int i = 0; i<output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(40);
            }
            catch (Exception e) {
            }
        }
    }
}