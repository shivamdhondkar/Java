public class LargeNumArray {
    public static void main(String args []){
        int [] arr = {10,20,30,40};
        int large= 0;
        for (int i = 0; i<arr.length; i++){
            if (large<arr[i]){ 
                large = arr[i];
            }
            
        }
        System.out.println(large);
    }

}
