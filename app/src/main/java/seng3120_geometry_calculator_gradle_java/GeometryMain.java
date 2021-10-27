package seng3120_geometry_calculator_gradle_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
    
public class GeometryMain {

    private static Cylinder cylinder;
    private static Sphere sphere;

    //main menu
    public static void mainMenu() {
        System.out.println("1. Cylinder");
        System.out.println("2. Sphere");
        System.out.println("3. etc");
        System.out.println("4. etc");
        System.out.println("0. Exit\n");
    
        //Get user input
        //good use of try/catch to catch errors in user input.
        try {
            int userInput = Integer.parseInt(inputOutput("Please select the geometric shape you wish to calculate: "));
            
            if (userInput >= 0 && userInput <=6) {
                if (userInput == 1) calcCylinder();
                if (userInput == 2) calcSphere();
                //if (userInput == 3)
                //if (userInput == 4)
            if (userInput == 0) System.exit(0);
            } else {
                System.out.println("Please enter a number from 0 - 2");
                mainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number from 0 - 2");
            mainMenu();
        }
    }

    //private method that uses the Cylinder class to calculate
    //volume and surfaceArea
    private static void calcCylinder(){

        System.out.println("----------------------------------------------------------");
        System.out.println("JAVA PROGRAM TO FIND VOLUME & SURFACE AREA OF A CYLINDER");
        System.out.println("----------------------------------------------------------");

        int userRadius = Integer.parseInt(inputOutput("Please enter the radius: "));
        int userHeight = Integer.parseInt(inputOutput("Please enter the height: "));

        double volume = cylinder.volume(userRadius, userHeight);

        System.out.println("\nThe Volume of a Cylinder = " + volume);

        mainMenu();

    }

    //starter code for the sphere.
    private static void calcSphere(){}

    //helper method to handle the CLI input.
    //Java doesn't have a graceful built-in way to handle this
    private static String inputOutput(String message) {
        System.out.println(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String returnString = "";
        try {
            returnString = br.readLine();
        }
        catch (IOException e){
            System.out.println("Error reading in value");
            mainMenu();
        }
        return returnString;
    }
        
    public static void main(String[] args) {
        //create the objects
        cylinder = new Cylinder();
        sphere = new Sphere();
        mainMenu();
    }
}
