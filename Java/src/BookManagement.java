class BookDetail {
    String title;
    String author;
    double price;

    public BookDetail(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class BookManagement {
    public static void main(String[] args) {
        BookDetail book1 = new BookDetail("The Alchemist", "Paulo Coelho", 350.0);
        BookDetail book2 = new BookDetail("Atomic Habits", "James Clear", 499.0);
        BookDetail book3 = new BookDetail("The Psychology of Money", "Morgan Housel", 299.0);

        System.out.println("--- Book List ---");
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();
    }
}