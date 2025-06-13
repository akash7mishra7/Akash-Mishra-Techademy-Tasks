public class FinallyDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
             int result = 10 / 0;
            System.out.println("This line executes if no exception occurs");
        }
        catch (ArithmeticException e) {
            System.out.println("Inside catch block - Exception caught: " + e.getMessage());
        }
        finally {
            System.out.println("Inside finally block - This always executes!");
        }
        System.out.println("Success!");
    }
}