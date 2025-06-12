public class ExceptionChaining {
    public static void main(String[] args) {
        try {
            processData();
        } catch (RuntimeException e) {
            System.out.println("Caught high-level exception: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
        }
    }

    static void processData() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            throw new RuntimeException("Data processing failed", e ); // Chain the original exception
        }
    }
}