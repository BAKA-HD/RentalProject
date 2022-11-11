import java.util.*;
import java.io.PrintWriter;

public class Main {
    // Creating a collection of type car as arrayList
    static ArrayList<Car> carsList=new ArrayList<Car>();//Creating Cars list
    static ArrayList<Customer> customerList=new ArrayList<Customer>();//Creating customer list
    static TransactionsManager manager = new TransactionsManager();
    static Scanner sc= new Scanner(System.in);
    static String newLine = System.getProperty("line.separator");

    static Customer currentCustomer;

    static void  bookACar() {
        Customer finalCustomer;
        // To rent to a specific customer
        System.out.print(newLine + "Do you want it to be booked for a specific customer? (Y/N): " + newLine);
        String answer= sc.next();
        if (answer.equals("Y") || answer.equals("y")) {
            System.out.print(newLine + "Choose a customer: " + newLine);
            showCustomers();
            int customerIndex = sc.nextInt();
            finalCustomer = customerList.get(customerIndex);

        } else {
            finalCustomer = currentCustomer;
        }

        System.out.print(newLine + "Choose a car based on the number:" + newLine);
        showCars();
        System.out.print("--> ");
        int carIndex = sc.nextInt();
        System.out.print(newLine + "Enter the day:" + newLine);
        int day = sc.nextInt();
        System.out.print(newLine + "Enter the month:" + newLine);
        int month = sc.nextInt();
        System.out.print(newLine + "Enter the year:" + newLine);
        int year = sc.nextInt();

        Car desiredCar = carsList.get(carIndex);
        Date requestedDate = new Date(day,month,year);

        Boolean isAvaliable = manager.checkAvaliblity(desiredCar, requestedDate);
        if (isAvaliable){
            desiredCar.rentCounter += 1;
            manager.makeTransaction(desiredCar, finalCustomer, requestedDate);
        }
    }

    static void addCar() {
        showCars();
        boolean isDone = false;
        do {
            try {
                System.out.println(newLine + "Enter the name of the car:" + newLine);
                String name = sc.next();
                System.out.println(newLine + "Enter the rental rate:" + newLine);
                int rentalRate = sc.nextInt();
                sc.nextLine();
                System.out.println(newLine + "Enter the milage:" + newLine);
                int milage = sc.nextInt();
                System.out.println(newLine + "Enter the plate number:" + newLine);
                String plate = sc.next();
                System.out.println(newLine + "Enter the brand:" + newLine);
                String brand = sc.next();
                System.out.println(newLine + "Enter the color:" + newLine);
                String color = sc.next();
                System.out.println(newLine + "Enter the version:" + newLine);
                String version = sc.next();
                Car car = new Car( name,  plate,brand, rentalRate, milage,  version, color, false, 0);
                if (validateCars(car)) {
                    carsList.add(car);
                    System.out.print("Car was added successfully!!");
                    isDone = true;
                } else {
                    System.out.print("Failed to add car, already existed");
                }
            }
            catch (Exception e) {
                System.out.println ("Please enter a valid value!");
            }
        } while (isDone == false);
    }

    static boolean validateCars(Car car){
        for(int i = 0; i <= carsList.stream().count() - 1; i = i + 1) {
            if (carsList.get(i).plateNumber.equals(car.plateNumber) ) {
                return false;
            }
        }
        return true;
    }

    static boolean validateCustomer(Customer customer){
        for(int i = 0; i <= customerList.stream().count() - 1; i = i + 1) {
            if (customerList.get(i).civilID.equals(customer.civilID) ) {
                return false;
            }
        }
        return true;
    }

    static void showCars() {
        System.out.print(" -- Current Cars:" + newLine);
        for(int i = 0; i <= carsList.stream().count() - 1; i = i + 1) {
            System.out.print("- " + i + " Name: " + carsList.get(i).carName + " Plate: " + carsList.get(i).plateNumber + newLine + "Color: " +carsList.get(i).color + newLine + "Version: " +carsList.get(i).carVersion + newLine);
        }
    }

    static void showCustomers() {
        for(int i = 0; i <= customerList.stream().count() - 1; i = i + 1) {
            System.out.print(newLine + "- " + i + " Name: " + customerList.get(i).name + " ID: " + customerList.get(i).civilID  + " City: " + customerList.get(i).cityOfBirth);
        }
        System.out.print(newLine + newLine + "Enter the index number of the customer:  ");
    }

    static void  printIntoTxt() {
        carsList.sort(Comparator.comparing(Car::getPlateNumber));
        try
        {
            PrintWriter pr = new PrintWriter("assignmentFile");
            pr.println(newLine + "** CARS **" + newLine);
            for (int i=0; i<carsList.stream().count() - 1 ; i++)
            {
                pr.println( "- " + i + " Name: " + carsList.get(i).carName + " Plate: " + carsList.get(i).plateNumber + newLine + "Color: " +carsList.get(i).color + newLine + "Version: " +carsList.get(i).carVersion + newLine);
            }
            pr.println(newLine + "** TRANSACTIONS **" + newLine);
            for (int i=0; i<manager.getTransactionsList().stream().count() - 1 ; i++)
            {
                pr.println("Customer: " + manager.getTransactionsList().get(i).customer.name + newLine);
                pr.println("Data: " + manager.getTransactionsList().get(i).date.day + "/" + manager.getTransactionsList().get(i).date.month + "/" + manager.getTransactionsList().get(i).date.year +  newLine);
                pr.println("Car: " + manager.getTransactionsList().get(i).car.carName + newLine + newLine);
            }
            pr.println(newLine + "** CUSTOMERS **" + newLine);
            for (int i=0; i<customerList.stream().count() - 1 ; i++)
            {
                pr.println("NAME: " + customerList.get(i).name + newLine);
                pr.println("CITY: " + customerList.get(i).cityOfBirth + newLine);
                pr.println("ID: " + customerList.get(i).civilID + newLine + newLine);
            }
            pr.close();
            System.out.println("SAVED INTO PROJECT DIREACTORY");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }

    static void setup(){
        System.out.print("Welcome to Makddad Rental!!" + newLine + "--> ");
        System.out.print(newLine + "** Enter your credentials **" + newLine);
        // Cutomer creation
        int customerInput = 0;
        boolean isDone = false;
        // Conver the loop to be a bollen loop
        do {
            try {
                System.out.println(newLine + "-Name: ");
                String customerName = sc.nextLine();
                System.out.println(newLine + "-Civil ID: ");
                int civilID = sc.nextInt();
                sc.nextLine();
                System.out.println(newLine + "-City: ");
                String customerCity = sc.nextLine();
                System.out.println(newLine + "-Nationality: ");
                String customerCountry = sc.nextLine();
                currentCustomer = new Customer(civilID,customerName,customerCity,customerCountry);
                if (validateCustomer(currentCustomer)) {
                    customerList.add(currentCustomer);
                    System.out.print("Customer was added successfully!!");
                    isDone = true;
                } else {
                    System.out.print("Failed to add customer, already existed");
                }
            }
            catch (Exception e) {
                System.out.println ("Please enter a valid value!");
            }
        } while (isDone == false);

        // User Input

        int userInput = 0;
        do {
            try {
                System.out.print(newLine + "** Enter a number to proceed **" + newLine + "- 1 Book a car" + newLine + "- 2 Add a car" + newLine + "- 3 Show transactions" + newLine + "- 4 Most rented car" + newLine + "- 5 Print into txt file" + newLine + "- 0 to exit"  + newLine + "--> ");
                userInput = sc.nextInt();
                if  (userInput == 1) {
                    bookACar();
                } else if (userInput == 2) {
                    addCar();
                } else if (userInput == 3) {
                    manager.showTransactions();
                } else if (userInput == 4) {
                    manager.showMostRentedCar();
                } else if (userInput == 5) {
                    printIntoTxt();
                } else if (userInput == 0) {
                    printIntoTxt();
                }
            } catch (Exception e) {
                System.out.println ("Please enter a valid value!");
            }
        } while (userInput != 0);
    }

}