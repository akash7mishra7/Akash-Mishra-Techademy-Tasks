import java.sql.*;
import java.util.Scanner;

public class CRUDApp {

    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "#Mission19181";

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        while (true) {
            System.out.println("\n📋 MENU:");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> viewUsers();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 5 -> {
                    System.out.println("Exiting...");
                    conn.close();
                    return;
                }
                default -> System.out.println("  Invalid choice!");
            }
        }
    }

    static void addUser() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);

        int rows = ps.executeUpdate();
        System.out.println("✅ User added. Rows affected: " + rows);
    }

    static void viewUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n👥 Users:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email"));
        }
    }

    static void updateUser() throws SQLException {
        System.out.print("Enter user ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        String sql = "UPDATE users SET name=?, email=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();
        System.out.println("✅ User updated. Rows affected: " + rows);
    }

    static void deleteUser() throws SQLException {
        System.out.print("Enter user ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println("🗑️ User deleted. Rows affected: " + rows);
    }
}
