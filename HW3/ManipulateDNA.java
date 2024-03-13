package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipulateDNA {
    public static void main(String[] args) throws FileNotFoundException {

        //Scanner object used to read filename from user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the filename: ");
        String filename = sc.nextLine();
        File dnaFile = new File(filename);

        //Another Scanner object used, but this one reads through the sequences in dnaFile
        Scanner fileScanner = new Scanner(dnaFile);

        //Initialized and built a list of sequences found in dnaFile
        List<String> sequenceList = new ArrayList<>();
        while (fileScanner.hasNext()) {
            sequenceList.add(fileScanner.next());
        }

        //Iterating through each sequence found in the dnaFile
        for (int i = 0; i < sequenceList.size(); i++) {

            System.out.println("\nSequence Number: " + (i + 1));
            System.out.println("Input Sequence: " + sequenceList.get(i));
            System.out.println("Reverse Sequence: " + (new StringBuilder(sequenceList.get(i)).reverse()));

            /* Needed to create another for-loop to iterate through the characters of each sequence in order to
            find their complements */
            StringBuilder complement = new StringBuilder();
            for (int j = 0; j < sequenceList.get(i).length(); j++) {

                char c = sequenceList.get(i).charAt(j);
                if (c == 'A') {complement.append('T');}
                else if (c == 'T') {complement.append('A');}
                else if (c == 'C') {complement.append('G');}
                else if (c == 'G') {complement.append('C');}
                else { //If the character in the sequence is not A,T,C, or G, we can't find the complement
                    complement = new StringBuilder();
                    complement.append("?");
                    }
                }

            System.out.println("Complement: " + complement);
            System.out.println("Reverse Complement: " + complement.reverse());
            }

        }



    }
