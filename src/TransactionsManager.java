import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class TransactionsManager {
    private ArrayList<Transactions> transactionsList=new ArrayList<Transactions>();//Creating customer list
    static String newLine = System.getProperty("line.separator");

    void makeTransaction(Car car, Customer customer, Date date) {
        Transactions transaction = new Transactions(car, customer, date);
        transactionsList.add(transaction);
    }

    void showTransactions() {
        if (!transactionsList.isEmpty()) {
            for(int i = 0; i<= transactionsList.stream().count() - 1; i = i + 1) {
                System.out.print("Customer: " + transactionsList.get(i).customer.name + newLine);
                System.out.print("Data: " + transactionsList.get(i).date.day + "/" + transactionsList.get(i).date.month + "/" + transactionsList.get(i).date.year +  newLine);
                System.out.print("Car: " + transactionsList.get(i).car.carName + newLine + newLine);
            }
        }
    }

    boolean checkAvaliblity(Car car, Date date) {
        for(int i = 0; i <= transactionsList.stream().count() - 1; i = i + 1) {
            Boolean dateCondition = (transactionsList.get(i).date.day.equals(date.day) && transactionsList.get(i).date.month.equals(date.month) && transactionsList.get(i).date.year.equals(date.year));
            // If it's the desired car
            if (transactionsList.get(i).car.equals(car)) {
                // If it's the same date
                if (dateCondition) {
                    System.out.print("Car already booked!!");
                    return false;
                }
            }
        }
        System.out.print("Car was booked successfully!!");
        return true;
    }

    Car showMostRentedCar() {
        Integer currentIndex = transactionsList.get(0).car.rentCounter;
        Integer nextIndex = 0;
        Car mostRentedCar = transactionsList.get(0).car;

        for(int i = 0; i <= transactionsList.stream().count() - 1; i = i + 1) {
            nextIndex = transactionsList.get(i).car.rentCounter;
            if (nextIndex > currentIndex) {
                currentIndex = nextIndex;
                mostRentedCar = transactionsList.get(i).car;
            }
        }

        System.out.print(newLine + "-Name: " + mostRentedCar.carName);
        System.out.print(newLine + "-Milage: " + mostRentedCar.milage);
        System.out.print(newLine + "-Brand: " + mostRentedCar.brand);
        System.out.print(newLine + "-Rented times: " + mostRentedCar.rentCounter + newLine);

        return mostRentedCar;
    }

    // To get the transaction
    public ArrayList<Transactions> getTransactionsList() {
        return transactionsList;
    }

}
