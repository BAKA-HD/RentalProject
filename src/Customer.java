import java.util.*;

public class Customer {
    Integer civilID;
    String name;
    String cityOfBirth;
    String nationality;

    public Customer(Integer civilID, String name, String cityOfBirth, String nationality) {
        this.civilID = civilID;
        this.name = name;
        this.cityOfBirth = cityOfBirth;
        this.nationality = nationality;
    }

    // Getter
    public Integer getCivilID() {
        return civilID;
    }

    public String getName() {
        return name;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public String getNationality() {
        return nationality;
    }
    // Setter
    public void setCivilID(Integer civilID) {
        this.civilID = civilID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "civilID=" + civilID +
                ", name='" + name + '\'' +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
