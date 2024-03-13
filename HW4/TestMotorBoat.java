package HW4;

import java.util.Scanner;

public class TestMotorBoat {

    public static void main(String[] args) {
        MotorBoat myMotorBoat = new MotorBoat();

        while(true){
            boolean isError = false;
            myMotorBoat.createBoat();

            // Error Handling Case 1 (a, b, c, & e)
            if ((myMotorBoat.max_speed_boat <= 0) || (myMotorBoat.curr_boat_speed <= 0)
                    || (myMotorBoat.motor_efficiency <= 0) || (myMotorBoat.curr_fuel_amount <= 0)
                    || (myMotorBoat.dist_travelled <= 0) || (myMotorBoat.fuel_tank_cap <= 0)) {
                System.out.println("Error: Each input parameter should be greater than 0");
                isError = true;
            }
            if (myMotorBoat.max_speed_boat > 50) {
                System.out.println("Error: Maximum speed should not be greater than 50 knots");
                isError = true;
            }
            if (myMotorBoat.motor_efficiency > 100) {
                System.out.println("Error: Motor efficiency should not be greater than 100%");
                isError = true;
            }
            if (myMotorBoat.fuel_tank_cap > 250) {
                System.out.println("Error: Fuel tank capacity should not be greater than 250 gallons");
                isError = true;
            }

            // Error Handling Case 2 (a & b)
            if (myMotorBoat.curr_boat_speed > myMotorBoat.max_speed_boat) {
                System.out.println("Error: Current speed should not be greater than maximum speed");
                isError = true;
            }
            if (myMotorBoat.curr_fuel_amount > myMotorBoat.fuel_tank_cap) {
                System.out.println("Error: Fuel amount should not be greater than fuel tank capacity");
                isError = true;
            }

            // Loops until user inputs values within the constraints
            if (isError) {
                System.out.println("Please fix your error(s) above and try again\n");
            } else {
                break;
            }
        }


        // Passed error check, program continues
        Scanner sc = new Scanner(System.in);
        System.out.println("\nFuel Amount: " + myMotorBoat.getCurrentFuel());
        System.out.print("Would you like to add more fuel (y/n): ");
        String response = sc.nextLine();

        // Error Handling
        while (!response.equals("y") && !response.equals("n")) {
            System.out.print("Error: Please enter y for yes or n for no: ");
            response = sc.nextLine();
        }

        if (response.equals("y")) {

            while(true){
                boolean isError = false;
                System.out.print("How much fuel would you like to add: ");
                int fuel_to_add = sc.nextInt();

                myMotorBoat.addFuel(fuel_to_add);

                // Error Handling
                if ((fuel_to_add < 0)){
                    System.out.println("Error: Cannot siphon fuel (number must be ≥ 0)");
                    isError = true;
                }

                // Error Handling Case 2 (c)
                if (myMotorBoat.getCurrentFuel() > myMotorBoat.fuel_tank_cap) {
                    System.out.println("Error: Fuel amount should not be greater than fuel tank capacity");
                    isError = true;
                }

                // Loops until user inputs values within the constraints
                if (isError) {
                    System.out.println("Please fix your error(s) above and try again\n");
                } else {
                    break;
                }
            }

            System.out.println("Fuel Amount: " + myMotorBoat.getCurrentFuel());
        }
        int operation_time;
        while (true) {
            System.out.print("How long would you like to operate the boat (hours): ");
            operation_time = sc.nextInt();
            boolean isError = false;

            // Error Handling Case 1 (d)
            if (operation_time > 8) {
                System.out.println("Error: Time should be no longer than 8 hours");
                isError = true;
            }

            // Error Handling
            if (operation_time < 0) {
                System.out.println("Error: Time should not be negative");
                isError = true;
            }

            // Loops until user inputs values within the constraints
            if (isError) {
                System.out.println("Please fix your error(s) above and try again\n");
            } else {
                break;
            }
        }

        // Operating Boat
        myMotorBoat.operateBoat(operation_time);

        System.out.println("\nRemaining fuel: " + myMotorBoat.getCurrentFuel());
        System.out.println("Updated distance: " + myMotorBoat.getDistanceTraveled());
    }
}
