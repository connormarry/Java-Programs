package HW1_and_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrintOdd {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Scanner for input/output names
        System.out.println("Enter the name of the input file: ");
        String inputName = sc.nextLine();
        System.out.println("Enter the name of the output file: ");
        String outputName = sc.nextLine();
        sc.close();

        try {
            File inFile = new File(inputName);  //create file to read from


            Scanner myReader = new Scanner(inFile);
            FileWriter myWriter = new FileWriter(outputName);

            StringBuilder outputString = new StringBuilder();
            while(myReader.hasNextLine()) {
                String inLine = myReader.nextLine(); //reads line of input file
                outputString.append(inLine.substring(inLine.indexOf(' ') + 1)).append("\n");
                //For each line, outputString appends the line of the input file with the first word removed.
            }

            myReader.close();

            myWriter.write(outputString.toString()); //write to output file
            myWriter.close();

            System.out.println("\n" + outputString );
        } catch(FileNotFoundException e) {
            System.out.println("Error, file not found");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}