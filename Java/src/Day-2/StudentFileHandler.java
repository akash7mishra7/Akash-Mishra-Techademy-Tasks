import java.io.*;
import java.util.*;

//public class StudentFileHandler {
//    public static void main(String[] args) {
//        List<String> students = new ArrayList<>(Arrays.asList("Akash", "Yash", "Dhruv"));
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
//            for (String name : students) {
//                writer.write(name);
//                writer.newLine();
//            }
//            System.out.println("Write Successful");
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        }
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
//            System.out.println("Names in uppercase:");
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line.toUpperCase());
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading from file: " + e.getMessage());
//        }
//    }
//}

public class StudentFileHandler {
    public static void main(String[] args) throws IOException {
        List<String> students = new ArrayList<>(Arrays.asList("Akash", "Yash", "Dhruv"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
        for (String name : students) {
            writer.write(name);
            writer.newLine();
        }
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
        System.out.println("Names in uppercase:");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line.toUpperCase());
        }
        reader.close();
    }
}