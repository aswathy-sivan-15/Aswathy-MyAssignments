package week2.day1;
public class ArrayIntersection
{
    public static void main(String[] args) {
        int a[] = {3,2,11,4,6,7};
        int b[] = {1,2,8,4,9,7};
        System.out.print("Matching Elements: ");
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {
                if(a[i]==b[j])
                    {
                        System.out.print(a[i] + " ");
                    }
                
                
            }
            
        }
    }

}