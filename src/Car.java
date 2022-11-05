import com.sun.org.apache.xpath.internal.operations.Bool;

public class Car {
    String carName;
    String plateNumber;
    String brand;
    Double rentalRate;
    Integer milage;
    String carVersion;
    String color;

    Boolean isRented;
    Integer rentCounter = 0;

    // Constructer
    public Car(String carName, String plateNumber, String brand, Double rentalRate, Integer milage, String carVersion, String color, Boolean isRented, Integer rentCounter) {
        this.carName = carName;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.milage = milage;
        this.carVersion = carVersion;
        this.color = color;
        this.isRented = isRented;
        this.rentCounter = rentCounter;
    }

    // Getters
    public String getCarName() {
        return carName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public Integer getMilage() {
        return milage;
    }

    public String getCarVersion() {
        return carVersion;
    }

    public String getColor() {
        return color;
    }

    // Setters
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setMilage(Integer milage) {
        this.milage = milage;
    }

    public void setCarVersion(String carVersion) {
        this.carVersion = carVersion;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    public Integer getRentCounter() {
        return rentCounter;
    }

    public void setRentCounter(Integer rentCounter) {
        this.rentCounter = rentCounter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", rentalRate=" + rentalRate +
                ", milage=" + milage +
                ", carVersion='" + carVersion + '\'' +
                ", color='" + color + '\'' +
                ", isRented=" + isRented +
                ", rentCounter=" + rentCounter +
                '}';
    }

}
