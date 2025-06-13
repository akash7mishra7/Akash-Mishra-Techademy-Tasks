abstract class Appliance {
    String brand;
    int power;

    Appliance(String brand, int power) {
        this.brand = brand;
        this.power = power;
    }

    abstract void turnOn();
    void showSpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Power: " + power + "W");
    }
}

class Fan extends Appliance {

    Fan(String brand, int power) {
        super(brand, power);
    }

    @Override
    void turnOn() {

        System.out.println(brand + " fan with is spinning!");
    }
}

class WashingMachine extends Appliance {

    WashingMachine(String brand, int power) {
        super(brand, power);
    }

    @Override
    void turnOn() {

        System.out.println(brand + " washing machine starting ");
    }
}

public class ApplianceController {
    public static void main(String[] args) {
        Fan myFan = new Fan("Usha", 50);
        WashingMachine myWasher = new WashingMachine("LG", 1200);

        System.out.println("--- Testing Fan ---");
        myFan.showSpecs();
        myFan.turnOn();

        System.out.println("\n--- Testing Washing Machine ---");
        myWasher.showSpecs();
        myWasher.turnOn();
    }
}