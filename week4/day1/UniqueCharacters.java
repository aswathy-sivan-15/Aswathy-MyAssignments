package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {

       String companyName = "google";

       // Create Set (maintains insertion order)
       Set<Character> uniqueChars = new LinkedHashSet<>();
       
       //Iterate through each character in the string and Add each character into the Set.
       for(char ch : companyName.toCharArray())
       {
        uniqueChars.add(ch);
       }

       //Print the unique characters
       System.out.print("Print the unique characters from the string: ");
       for(char ch : uniqueChars)
       {
        System.out.print(ch + " ");
       }
       
    }

}
