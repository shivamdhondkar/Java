import java.util.*;
class Calculation {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter two number : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        //addition
        int sum = num1 + num2;
        System.out.println("addition = "+sum);

        //multiplication
        int mul = num1*num2;
        System.out.println("Multiplication = "+mul);

        //substraction
        int sub = num1-num2;
        System.out.println("Substraction = "+sub);

        //division
        int div = num1/num2;
        System.out.println("Division = "+div);

    }
    
}
