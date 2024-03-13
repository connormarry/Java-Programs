package HW4;


import java.text.DecimalFormat;
import java.util.Scanner;

public class MotorBoat {

    // Attributes

    public static final DecimalFormat df = new DecimalFormat("0.000000");
    public double fuel_tank_cap;
    public double curr_fuel_amount;
    public double max_speed_boat;
    public double curr_boat_speed;
    public double motor_efficiency;
    public double dist_travelled;


    // Construct instance of the motorboat, accept inputs for parameters

    public void createBoat(){

        Scanner input_stream = new Scanner(System.in);
        //store all user inputs in variables
        System.out.print("Enter the capacity of the fuel tank: ");
        this.fuel_tank_cap = Integer.parseInt(input_stream.nextLine());
        System.out.print("Enter the amount of fuel in the tank: ");
        this.curr_fuel_amount = Integer.parseInt(input_stream.nextLine());
        System.out.print("Enter the maximum speed: ");
        this.max_speed_boat = Integer.parseInt(input_stream.nextLine());
        System.out.print("Enter the current speed: ");
        this.curr_boat_speed = Integer.parseInt(input_stream.nextLine());
        System.out.print("Enter the efficiency(percentage): ");
        this.motor_efficiency = Integer.parseInt(input_stream.nextLine());
        System.out.print("Enter the total distance traveled so far: ");
        this.dist_travelled = Integer.parseInt(input_stream.nextLine());
        System.out.println();
    }


    // fuel burn = ( (current speed)^2 x efficiency x time)/100
    //  distance = (current speed) x time

    // Methods

    public void changeSpeed(double num) {
        this.curr_boat_speed = num;
    }

    public void addFuel(int num) {
        this.curr_fuel_amount += num;
    }

    public double getCurrentFuel() {
        return this.curr_fuel_amount;
    }

    public double getDistanceTraveled() {
        return this.dist_travelled;
    }

    public void operateBoat(int t) {
        double fuel_burn = (Math.pow(this.curr_boat_speed, 2) * this.motor_efficiency * t)/100;
        if(fuel_burn > this.curr_fuel_amount){
            System.out.println("\nNot enough fuel, cannot operate the motorboat");
        } else {
            System.out.println("\nOperating the motorboat");
            this.curr_fuel_amount = this.curr_fuel_amount - fuel_burn;
            this.dist_travelled += this.curr_boat_speed * t;
        }
    }
}
