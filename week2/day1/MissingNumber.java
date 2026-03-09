package week2.day1;

//import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int a[] = {1, 4,3,2,8, 6, 7};
        //Sort the array
        for (int i = 0; i < a.length ; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                }
                
            }
            
        }
        //Arrays.sort(a);
        System.out.print("Sorted Array: ");
       
        for (int i = 0; i < a.length; i++) {
            
            System.out.print(a[i] + " ");
           
        }
        //find the missing number
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != i+1) {
                System.out.println("Missing number is: " + (i+1) );
                break;
            }
        }
    }
}
