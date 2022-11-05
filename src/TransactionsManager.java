import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class TransactionsManager {
    private ArrayList<Transactions> transactionsList=new ArrayList<Transactions>();//Creating customer list

    void makeTransaction(Car car, Customer customer, Date date) {
        Transactions transaction = new Transactions(car, customer, date);
        transactionsList.add(transaction);
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
    // To get the transaction
    public ArrayList<Transactions> getTransactionsList() {
        return transactionsList;
    }

}
