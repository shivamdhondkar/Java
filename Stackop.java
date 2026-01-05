
import java.util.Stack;

public class Stackop {

    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(20);
        s.push(10);
        s.push(30);

        for (int i = 0; i < 10; i++) {
            s.push(i);
        }

        System.out.println(s);
        System.out.println(s.isEmpty());
        System.out.println(s.peek());

        
    }
    
}
