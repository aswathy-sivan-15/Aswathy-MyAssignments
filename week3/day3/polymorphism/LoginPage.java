package week3.day3.polymorphism;

public class LoginPage extends BasePage {
   
    @Override
    public void performCommonTasks()
    {
        System.out.println("Performing tasks of Login Page");
    }
    public static void main(String[] args) {
        //Creating parent class object
        BasePage bp = new BasePage();
        //calling Basepage class methods
        bp.clickElement();
        bp.findElement();
        bp.enterText();
        bp.performCommonTasks();
        System.out.println("----------------------------------");
        //Creating child class object
        LoginPage lp = new LoginPage();
        //calling inherited methods
        lp.clickElement();
        lp.findElement();
        lp.enterText();
        //calling overridden method
        lp.performCommonTasks();

         System.out.println("----------------------------------");
        //Reference type parent class and creating object for child class
        BasePage bpL = new LoginPage();
        bpL.clickElement();
        bpL.enterText();
        bpL.findElement();
        bpL.performCommonTasks();

    }

}
