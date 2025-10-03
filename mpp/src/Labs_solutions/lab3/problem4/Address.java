package Labs_solutions.lab3.problem4;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "[ Street: " + street + ", City: " + city + ", State: " + state + ", Zip: " + zip + " ]";
    }
}
