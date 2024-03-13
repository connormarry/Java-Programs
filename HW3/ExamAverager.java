package HW3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class ExamAverager {
    private static final DecimalFormat df = new DecimalFormat("0.000000");
    public static void main(String[] args) {

        System.out.println("This program computes the average of a list of (nonnegative) exam scores.");
        //user a bool to track whether or not another list average needs to be calculated
        boolean calculate_avg = true;

        //scan from standard in for user inputs
        Scanner input = new Scanner(System.in);

        while(calculate_avg) {
            //calculate the average for given inputs
            averaging_tool();

            //keep calling averaging_tool until user inputs "n"
            System.out.println("Want to average another exam?");
            System.out.print("Enter y or n: ");
            String repeat = input.nextLine();

            //ensure that user is only inputting either y or n for question
            while(!repeat.equals("y") && !repeat.equals("n")){
                System.out.print("Error! Please enter y for yes or n for no: ");
                repeat = input.nextLine();
            }
            calculate_avg = repeat.equals("y");
        }
    }

    public static void averaging_tool() {
        Scanner input_stream = new Scanner(System.in);

        System.out.println("Enter all the scores to be averaged.");
        System.out.println("Enter a negative number after you have entered all the scores.");

        //make an array list of doubles
        List<java.lang.Double> scores = new ArrayList<>();

        //add all the nonnegative inputs to the scores list
        while(true){
            double temp = input_stream.nextDouble();
            if (temp < 0){
                break;
            }
            scores.add(temp);
        }

        //loop through the scores list and add all the numbers in the list together
        double average = 0.0;
        for(int i = 0; i < scores.size(); i++){
            average = average + scores.get(i);
        }
        //divide the sum by the size of the list
        average = average / (scores.size());
        System.out.println("The average is: " + average);

        //list each score and whether it's below or above average
        for(int i = 0; i < scores.size(); i++){
            int score_num = i+1;
            double curr_score = scores.get(i);

            if(curr_score < average){
                System.out.println("Score #" + score_num + ": " + df.format(curr_score) + " -- " + "Below average");
            } else{
                System.out.println("Score #" + score_num + ": " + df.format(curr_score) + " -- " + "Above average");
            }
        }
    }
}
