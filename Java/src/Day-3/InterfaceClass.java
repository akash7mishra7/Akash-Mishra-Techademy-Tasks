
interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started with key ignition");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped by applying brakes");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started with kick starter");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped by foot brake");
    }
}

public class InterfaceClass {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        myCar.stop();

        Vehicle myBike = new Bike();
        myBike.start();
        myBike.stop();
    }
}