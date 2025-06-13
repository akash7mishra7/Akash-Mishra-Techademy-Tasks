import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }


    public String toString() {
        return name + " (₹" + price + ", " + category + ")";
    }
}

public class ProductFilter {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 45000, "Electronics"),
                new Product("Mouse", 499, "Electronics"),
                new Product("Notebook", 50, "Stationery"),
                new Product("Headphones", 799, "Electronics"),
                new Product("Pen", 10, "Stationery"),
                new Product("USB Cable", 199, "Electronics")
        ));

        System.out.println("Products under ₹500:");
        products.stream()
                .filter(p -> p.getPrice() < 500)
                .forEach(p -> System.out.println(p));

        System.out.println("\nElectronics products:");
        products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));

        System.out.println("\nProducts sorted by price:");
        products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .map(p -> p.getName() + " (₹" + p.getPrice() + ")")
                .forEach(item -> System.out.println(item));
    }
}