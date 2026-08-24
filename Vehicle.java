import java.util.Scanner;

abstract class Vehicle {
    String vehicleNumber;
    String brand;

    Vehicle(String no, String vehicleBrand) {
        vehicleNumber = no;
        brand = vehicleBrand;
    }

    abstract void startEngine();

    final void showVehicleIdentity() {
        if (vehicleNumber.isEmpty()) {
            System.out.println("Invalid vehicle number");
        } else if (brand.isEmpty()) {
            System.out.println("Invalid brand name");
        } else {
            System.out.println("Vehicle No: " + vehicleNumber);
            System.out.println("Brand: " + brand);
        }
    }
}

class Car extends Vehicle {

    Car(String no, String vehicleBrand) {
        super(no, vehicleBrand);
    }

    void startEngine() {
        System.out.println("Car engine starts");
    }
}

class Bike extends Vehicle {

    Bike(String no, String vehicleBrand) {
        super(no, vehicleBrand);
    }

    void startEngine() {
        System.out.println("Bike engine starts");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Bike Details");
        System.out.println("2. Car Details");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter Bike Vehicle Number: ");
            String bikeNo = sc.nextLine();

            System.out.print("Enter Bike Brand: ");
            String bikeBrand = sc.nextLine();

            Bike bike = new Bike(bikeNo, bikeBrand);

            System.out.println("\n--- Bike Details ---");
            bike.showVehicleIdentity();

            if (!bikeNo.isEmpty() && !bikeBrand.isEmpty()) {
                bike.startEngine();
            }

        } else if (choice == 2) {

            System.out.print("Enter Car Vehicle Number: ");
            String carNo = sc.nextLine();

            System.out.print("Enter Car Brand: ");
            String carBrand = sc.nextLine();

            Car car = new Car(carNo, carBrand);

            System.out.println("\n--- Car Details ---");
            car.showVehicleIdentity();

            if (!carNo.isEmpty() && !carBrand.isEmpty()) {
                car.startEngine();
            }

        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
