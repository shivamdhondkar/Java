//Run Time Polymorphism Example in Java
// This code demonstrates run-time polymorphism through method overriding.
// The Animal class has a method 'sound' that is overridden in the Dog class.
// The main method creates an instance of Dog but references it with an Animal type.

class Animal{
    void sound(){
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal{
    void sound(){
        System.out.println("Dog barks");
    }
}

public class RunTimePoly {
    public static void main(String args[]){
        System.out.println("Run time polymorphism example.");
        Animal Ani = new Dog();
        Ani.sound();
    }
    
}
