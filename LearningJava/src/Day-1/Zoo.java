// Base class
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

// Derived class Dog
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog - Woof!");
    }
}

// Derived class Cat
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("cat - Meow!");
    }
}

// Derived class Cow
class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cow - Moo!");
    }
}

public class Zoo {
    public static void main(String[] args) {

        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal cow = new Cow();

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
        cow.makeSound();
    }
}