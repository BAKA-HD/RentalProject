import java.util.*;
public class Transactions {
    Car car;
    Customer customer;
    Date date;
    public Transactions(Car car, Customer customer, Date date) {
        this.car = car;
        this.customer = customer;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "car=" + car +
                ", customer=" + customer +
                ", date=" + date +
                '}';
    }
}

class Date {
    Integer day;
    Integer month;
    Integer year;

    public Date(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

}
