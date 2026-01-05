
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
        num.first(115);
    }
}
