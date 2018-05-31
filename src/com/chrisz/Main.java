package com.chrisz;
/* NOTES ON POLYMORPHISM

overloading / in same class / static / compile-time / early binding

overriding / in different classes / dynamic / run-time / late binding

When/why to assign PARENT REFERENCE TO CHILD OBJECT
https://www.youtube.com/watch?v=3xsRywYBfVU

Child c = new Child
1. Runtime - know what type of object you are going to get
2. Can call parent and child methods

Parent p = new Child
1. Runtime - don't know what type of object you are going to get
2. Can call only parent methods and override methods in child

More on point 1: if an array a hold an array list in index 1 and a linked list in index 2
List l = new a[1] -> this will work because the object "List" is a parent of both array lists and linked lists
*/

// We are going to go back to the car analogy.
// Create a base class called Car
// It should have a few fields that would be appropriate for a generice car class.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.
//
// Create appropriate getters
//
// Create some methods like startEngine, accelerate, and brake
//
// show a message for each in the base class
// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.
// put all classes in the one java file (this one).

public class Main {

    public static void main(String[] args) {
	    Integra car1 = new Integra();
        System.out.println(car1.getClass().getSimpleName() + " created, calling accelerate.");
        car1.accelerate();
        System.out.println("\n");

        RandomCar car2 = new RandomCar();
        System.out.println("RandomCar created, calling accelarate.");
        car2.accelerate(); // will execute override method
        System.out.println(car2.getWheels());

        Car car3 = new Integra();
        System.out.println(car1.getClass().getSimpleName() +  " / car 3 created"); // Integra / car 3 created
        car3.accelerate(); // will execute override method in Integra
        // car3.integraMethod(); -> won't work
    }
}

class Car {
    private String name; //name of car
    private boolean engine = true;
    private int cylinders;
    private int wheels = 4;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
    }

    public void startEngine() {
        System.out.println("In Car, engine has started.");
    }

    public void accelerate() {
        System.out.println("In Car, car has accelerated.");
    }

    public void brake() {
        System.out.println("In Car, car has braked.");
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}

class Integra extends Car {
    public Integra() {
        super("Integra", 4);
    }

    @Override
    public void accelerate() { // cannot make this a static method
        System.out.println("In Integra, car has accelerated.");;
    }

    public void integraMethod() {
        System.out.println("Integra only method");
    }
}

class RandomCar extends Car {
    public RandomCar() {
        super("Random Car", 6);
    }

}
