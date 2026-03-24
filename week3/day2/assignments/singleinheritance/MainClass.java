package week3.day2.assignments.singleinheritance;

public class MainClass {
    public static void main(String[] args) {
        //create object for super class and call its methods
        TestData td = new TestData();
        td.enterCredentials();
        td.navigateToHomePage();
        System.out.println("---------------------------");

        //create object for sub class
        LoginTestData ltd = new LoginTestData();
        //calling super class methods using sub class object
        System.out.println("");
        ltd.enterCredentials();
        ltd.navigateToHomePage();

        //call sub class methods
        ltd.enterUsername();
        ltd.enterPassword();


    }

}
