//Method Overloading Example.
// This code demonstrates compile-time polymorphism through method overloading.
// in Java. The Compile class has two overloaded methods named 'add' that accept different parameter types.

class Compile{
    public void add(int a, int b){
        int sum = a+b;
        System.out.println("Sum: " + sum);
    }

    public void add(double a, double b){
        double sum = a+b;
        System.out.println("Sum: " + sum);
    }
}


public class CompileTimePoly {
    public static void main(String[] args) {
        System.out.println("Compile-time polymorphism example.");

        Compile comp = new Compile();
        comp.add(10,20);
        comp.add(20.2,30.2);

    }
    
}
