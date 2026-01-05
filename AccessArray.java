public class AccessArray {
    public static void main(String args[])
    {
        int[] arr ={10,20,30,40,50,60,70,80,90,100};
        System.out.println(arr.length);
        System.out.println("Accessing array elements:");
        for (int i=0; i<arr.length;i++)
        {
            System.out.println(i+"."+arr[i]);
        }
        System.out.println(arr[5]);
        arr[5] = 500;
        System.out.println("After modification:");
        System.out.println(arr[5]);
    }
    
}
