import java.util.*;
import java.util.stream.*;

class Book3 {
    String title;
    String author;
    double price;
    int year;

    public Book3(String title, String author, double price, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getYear() { return year; }
}

public class LibraryFilter {
    public static void main(String[] args) {
        List<Book3> Books = Arrays.asList(
                new Book3("The Silent Patient", "Alex Michaelides", 350, 2019),
                new Book3("Atomic Habits", "James Clear", 499, 2018),
                new Book3("Sapiens", "Yuval Noah Harari", 599, 2011),
                new Book3("Educated", "Tara Westover", 450, 2018),
                new Book3("The Midnight Library", "Matt Haig", 399, 2020)
        );

        // Filter Books published after 2015
        System.out.println("Books published after 2015:");
        Books.stream()
                .filter(b -> b.getYear() > 2015)
                .forEach(b -> System.out.println(b.getTitle()));

        // Find the most expensive Books
        System.out.println("\nMost expensive Books:");
        Books.stream()
                .reduce((b_1, b_2) -> b_1.getPrice() > b_2.getPrice() ? b_1 : b_2)
                .ifPresent(b -> System.out.println(b.getTitle() + " - ₹" + b.getPrice()));

        // List all titles in alphabetical order
        System.out.println("\nBooks titles (A-Z):");
        Books.stream()
                .map(b -> b.getTitle())
                .sorted((t1, t2) -> t1.compareTo(t2))
                .forEach(t -> System.out.println(t));
    }
}