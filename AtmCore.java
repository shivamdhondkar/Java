
import java.util.Scanner;

public class AtmCore {

    long balance = 10000;
	long mobile_no;
    long withamt;
    long depamt;
    static int trType;

    static Scanner sc = new Scanner(System.in);

    public void display(){
        System.out.println("Balance : "+balance);
    }

    public void deposit(){
        System.out.println("Enter amount to deposit : ");
        depamt = sc.nextInt();

        if(depamt>0){
            balance = balance + depamt;
        }
        else{
            System.out.println("Invalid amount");
        }
                
    }

    public void with(){
        System.out.println("Enter amount to withdraw : ");
        withamt = sc.nextInt();

        if(withamt > 0 && withamt <= balance){
            balance = balance-withamt;
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    static void exit() {
        System.out.println("Thank you for using ATM. Visit Again!");
        System.exit(0);
    }

	public static void main(String args[]) 
    {
        AtmCore a = new AtmCore();

        while(true){

		System.out.println("Welcome\n Choose transaction type: \n 1 : Check Balance \n 2 : Deposit Amount \n 3 : Withdraw Amount \n 4 : Exit");
        
        System.out.println("Enter Transaction type : ");
        trType = sc.nextInt();

        

        

        switch (trType) {
            case 1:
                a.display();
                break;

            case 2:
                a.deposit();
                break;
            case 3:
                a.with();
                break;

            case 4:
                a.exit();
                break;
            default:
                System.out.println("Invalid Choise!! Try again");
        }
    }
	}
}
