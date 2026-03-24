package week3.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;



public class LeafgroundButtonInteraction {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://leafground.com/button.xhtml");
        driver.manage().window().maximize();
        //Click on the button with the text ‘Click and Confirm title
        driver.findElement(By.xpath("//span[text()='Click']")).click();
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("dashboard"))
        {
            System.out.println("Title verification successful");
        }
        else
        {
            System.out.println("Title verfication failed");
        }
        driver.navigate().back();
        boolean btnD = driver.findElement(By.xpath("//button[contains(@class, 'ui-state-disabled')]")).isEnabled();
        if(btnD)
        {
            System.out.println("button with the text 'Confirm' is enabled");
        }
        else
        {
            System.out.println("button with the text 'Confirm' is disabled");
        }
        //Find and print the position of the button with the text ‘Submit
        Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
        //print X and Y
        System.out.println("X cordinate: " + location.getX());
        System.out.println("Y cordinate: " + location.getY());
        //background color of the button with the text ‘Find the Save button color
       String color = driver.findElement(By.xpath("//span[text()='Save']/parent::button")).getCssValue("background-color");
       System.out.println("Background colour: " + color);
       //height and width of the button with the text ‘Find the height and width of this button
       Dimension size = driver.findElement(By.xpath("//h5[contains(text(),'height')]/following-sibling::button")).getSize();
       System.out.println("Height: " + size.getHeight()); 
       System.out.println("Width: " + size.getWidth()); 
       driver.quit();

    }

}
