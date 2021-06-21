package javareadwriteexample1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaReadWriteExample1 {

    public static void main(String[] args) {

        File countries = new File("countries1.txt");
        File capitals = new File("capitals1.txt");

        String countryName;
        String capitalName;

        try (
                Scanner input = new Scanner(countries);
                PrintWriter output = new PrintWriter(capitals);
                Scanner in = new Scanner(System.in);) {
            
            while (input.hasNextLine()) {
                countryName = input.nextLine();
                System.out.println("What is the capital name of: " + countryName);
                capitalName = in.nextLine();

                output.print(countryName);
                output.print("\t");
                output.println(capitalName);
            }// end while
            
            //output.close(); // close the PrintWriter
            //in.close(); // close the scanner (System.in)
        } // end try
        catch (IOException ex) {
            System.out.println("File not found: " + ex.toString());
        }

    }

}
