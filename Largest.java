import java.util.*;
class Largest 
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers to check : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if(num1>num2 && num1>num3){
            System.out.println("Number 1 is greater");
        }
        else if(num2>num1 && num2>num3){
            System.out.println("Number 2 is greater");
        }
        else{
            System.out.println("Number 3 is greater");
        }
    }
    
}
