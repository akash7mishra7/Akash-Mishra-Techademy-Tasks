public class NestedTryCatchBlocks {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        String str = null;
        Object Obj = "123";

        try {
            System.out.println("Outer try block started");
            try {
                System.out.println("\nInner try block (Level 1) started");

                // Scenario 1: Array access (may throw ArrayIndexOutOfBoundsException)
                System.out.println("Accessing array element: " + numbers[5]);

                // Scenario 2: Type casting (may throw ClassCastException)
                Integer num = (Integer) Obj;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Level 1 catch (Array): Array index error - " + e.getMessage());

                try {
                    System.out.println("\nInner try block (Level 2) started");
                    System.out.println("Dividing by zero: " + (10 / 0));

                } catch (ArithmeticException ex) {
                    System.out.println("Level 2 catch: Math error - " + ex.getMessage());
                }

            } catch (ClassCastException e) {
                System.out.println("Level 1 catch (ClassCast): Invalid type conversion - " + e.getMessage());
            }

            // Scenario 3: Null reference (may throw NullPointerException)
            System.out.println("\nTrying to get string length...");
            System.out.println("String length: " + str.length());

            // Scenario 4: Number format (may throw NumberFormatException)
            int x = Integer.parseInt("ABC");

        } catch (NullPointerException e) {
            System.out.println("Outer catch (NullPointer): Null reference error - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Outer catch (NumberFormat): Invalid number format - " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed - Cleanup complete");
        }

        System.out.println("\nProgram continues after all try-catch blocks");
    }
}