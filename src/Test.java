import java.util.*;
import java.io.PrintWriter;

public class Test {
    static Main main = new Main();

    public static void main(String[] args) {
        setupCarsCollection();
        setupCustomerCollection();
        setupTransactions();
        main.setup();

    }

    static void setupCarsCollection() {
        Car first = new Car( "Camry",  "AAA123","Toyota", 609, 23732,  "Limited", "Blue", false, 0);
        Car second = new Car( "Sonata",  "BBB123","Hyundia", 408, 96000,  "Standard", "White", false, 0);
        Car third = new Car( "Patrol",  "CCC123","Nissan", 1199, 71732,  "Black Edition", "Black", false, 1);
        Car fourth = new Car( "K5",  "DDD123","Kia", 394, 29732,  "Full Option", "Red", false, 0);
        main.carsList.add(first);
        main.carsList.add(second);
        main.carsList.add(third);
        main.carsList.add(fourth);
    };
    static void setupCustomerCollection() {
        Customer first = new Customer(1876549287, "Makddad Almakbout", "AlAhsaa", "Saudi Arabian");
        Customer second = new Customer(1076964687, "Turki Sakhm", "Riyadh", "Saudi Arabian");
        Customer third = new Customer(1936549287, "Dox Almodax", "Dammam", "Saudi Arabian");
        main.customerList.add(first);
        main.customerList.add(second);
        main.customerList.add(third);
    };

    static void setupTransactions(){
        // Same car different day
        main.manager.makeTransaction(main.carsList.get(0), main.customerList.get(0), new Date(1,1,2022));
        main.manager.makeTransaction(main.carsList.get(0), main.customerList.get(1), new Date(2,1,2022));

        main.manager.makeTransaction(main.carsList.get(1), main.customerList.get(0), new Date(1,1,2022));
        main.manager.makeTransaction(main.carsList.get(1), main.customerList.get(2), new Date(2,1,2022));

        main.manager.makeTransaction(main.carsList.get(2), main.customerList.get(2), new Date(1,1,2022));
        main.manager.makeTransaction(main.carsList.get(2), main.customerList.get(0), new Date(2,1,2022));
    }
}
