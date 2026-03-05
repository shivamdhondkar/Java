import java.util.Scanner;

public class FirstNum {
    public static int first(int n){

        while (n>=10){
            n= n/10;
        }
        System.out.println(n);

        return n;

    }
    
    public static void main (String args[]){
        FirstNum num = new FirstNum();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number for selection of first number :");
        int number = sc.nextInt();
        num.first(number);
    }
}
