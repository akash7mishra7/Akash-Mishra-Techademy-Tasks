import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    void display() {
        System.out.println(title + " by " + author +
                " (" + (isAvailable ? "Available" : "Borrowed") + ")");
    }
}

class Member {
    String name;
    List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    void borrowBook(Book book) {
        if (book.isAvailable) {
            borrowedBooks.add(book);
            book.isAvailable = false;
            System.out.println(name + " borrowed " + book.title);
        } else {
            System.out.println("Sorry, " + book.title + " is not available");
        }
    }

    void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.isAvailable = true;
            System.out.println(name + " returned " + book.title);
        } else {
            System.out.println(name + " didn't borrow this book");
        }
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Added book: " + title);
    }

    void addMember(String name) {
        members.add(new Member(name));
        System.out.println("Added member: " + name);
    }

    void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            book.display();
        }
    }

    void showMembers() {
        System.out.println("\nLibrary Members:");
        for (Member member : members) {
            System.out.println(member.name);
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("The Alchemist", "Paulo Coelho");
        library.addBook("Atomic Habits", "James Clear");

        library.addMember("Akash");
        library.addMember("Yash");

        Book b1 = library.books.get(0);
        Book b2 = library.books.get(1);
        Member m1 = library.members.get(0);
        Member m2 = library.members.get(1);

        m1.borrowBook(b1);
        m2.borrowBook(b2);
        m1.borrowBook(b2);
        m1.returnBook(b1);

        library.showBooks();
        library.showMembers();
    }
}