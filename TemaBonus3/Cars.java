public class Cars {
    String Brand;
    int yearOfFabrication;
    String color;
    double price;

    public Cars(String brand, int yearOfFabrication, String color, double price) {
        Brand = brand;
        this.yearOfFabrication = yearOfFabrication;
        this.color = color;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return Brand;
    }
}
