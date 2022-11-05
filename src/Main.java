import java.util.*;

public class Main {
    // Creating a collection of type car as arrayList
    static ArrayList<Car> carsList=new ArrayList<Car>();//Creating Cars list
    static ArrayList<Customer> customerList=new ArrayList<Customer>();//Creating customer list
    static TransactionsManager manager = new TransactionsManager();
    static Scanner sc= new Scanner(System.in);
    static String newLine = System.getProperty("line.separator");
    public static void main(String[] args) {
        setupCarsCollection();
        setupCustomerCollection();
        setupTransactions();

        // User Input
        System.out.print("Welcome to Makddad Rental!!" + newLine + "--> ");
        // You need to take user credintals before entering the loop and storing it in customerList
        int input = 0;
        do {
            System.out.print(newLine + "** Enter a number to proceed **" + newLine + "- 1 to book a car" + newLine + "- 2 to add a car" + newLine + "- 0 to exit" + newLine + "--> ");
            input = sc.nextInt();
            if  (input == 1) {
                bookACar();
            } else if (input == 2) {
                addCar();
            }
        } while (input != 0);
    }

    static void setupTransactions(){
        // Same car different day
        manager.makeTransaction(carsList.get(0), customerList.get(0), new Date(1,1,2022));
        manager.makeTransaction(carsList.get(0), customerList.get(1), new Date(2,1,2022));

        manager.makeTransaction(carsList.get(1), customerList.get(0), new Date(1,1,2022));
        manager.makeTransaction(carsList.get(1), customerList.get(2), new Date(2,1,2022));

        manager.makeTransaction(carsList.get(2), customerList.get(2), new Date(1,1,2022));
        manager.makeTransaction(carsList.get(2), customerList.get(0), new Date(2,1,2022));
    }

    static void  bookACar() {
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
            manager.makeTransaction(desiredCar, customerList.get(1), requestedDate);
        }
    }

    static void addCar() {
        showCars();
        System.out.print(newLine + "Enter the name of the car:" + newLine);
        System.out.print("--> ");
        String name = sc.next();
        System.out.print(newLine + "Enter the plate number:" + newLine);
        System.out.print("--> ");
        String plate = sc.next();
        System.out.print(newLine + "Enter the brand:" + newLine);
        System.out.print("--> ");
        String brand = sc.next();
        System.out.print(newLine + "Enter the rental rate:" + newLine);
        System.out.print("--> ");
        double rentalRate = sc.nextDouble();
        System.out.print(newLine + "Enter the milage:" + newLine);
        System.out.print("--> ");
        int milage = sc.nextInt();
        System.out.print(newLine + "Enter the color:" + newLine);
        System.out.print("--> ");
        String color = sc.next();
        System.out.print(newLine + "Enter the version:" + newLine);
        System.out.print("--> ");
        String version = sc.next();
        Car result = new Car( name,  plate,brand, rentalRate, milage,  version, color, false, 0);
        carsList.add(result);
        System.out.print("Car was added successfully!!");
    }

    static void setupCarsCollection() {
        Car first = new Car( "Camry",  "AAA123","Toyota", 609.00, 23732,  "Limited", "Blue", false, 0);
        Car second = new Car( "Sonata",  "BBB123","Hyundia", 408.4, 96000,  "Standard", "White", false, 0);
        Car third = new Car( "Patrol",  "CCC123","Nissan", 1199.00, 71732,  "Black Edition", "Black", false, 0);
        Car fourth = new Car( "K5",  "DDD123","Kia", 394.00, 29732,  "Full Option", "Red", false, 0);
        carsList.add(first);
        carsList.add(second);
        carsList.add(third);
        carsList.add(fourth);
    };
    static void setupCustomerCollection() {
        Customer first = new Customer(1876549287, "Makddad Almakbout", "AlAhsaa", "Saudi Arabian");
        Customer second = new Customer(1076964687, "Turki Sakhm", "Riyadh", "Saudi Arabian");
        Customer third = new Customer(1936549287, "Dox Almodax", "Dammam", "Saudi Arabian");
        customerList.add(first);
        customerList.add(second);
        customerList.add(third);
    };

    static void showCars() {
        System.out.print(" -- Current Cars:" + newLine);
        for(int i = 0; i <= carsList.stream().count() - 1; i = i + 1) {
            System.out.print("- " + i + " Name: " + carsList.get(i).carName + " Plate: " + carsList.get(i).plateNumber + newLine + "Color: " +carsList.get(i).color + newLine + "Version: " +carsList.get(i).carVersion + newLine);
        }
    }
}