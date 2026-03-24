package week3.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import week1.day2.Firefox;

public class Checkbox {
    public String checkboxStatus(String msg) {

        if (msg.equalsIgnoreCase("checked")) {
            return ("Checked");
        } else {
            return ("UnChecked");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.navigate().to("https://leafground.com/checkbox.xhtml");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Click on the "Basic Checkbox
        driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox')])[1]")).click();

        // Click on the "Notification Checkbox
        driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox')])[2]")).click();

        String msg = driver.findElement(By.className("ui-growl-title")).getText();
        Checkbox cb = new Checkbox();
        String status1 = cb.checkboxStatus(msg);
        System.out.println("Notification checkbox status is " + status1);

        // if(msg.equalsIgnoreCase("checked"))
        // {
        // System.out.println("Notification checkbox is checked");
        // }
        // else{
        // System.out.println("Notification checkbox is unchecked");

        // }

        // Click on your favorite language
        driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div")).click();

        // Click on the "Tri-State Checkbox
        boolean triSE = driver
                .findElement(By.xpath("//div[contains(@id,'ajaxTriState')]//div[contains(@class,'ui-chkbox-box')]"))
                .isEnabled();
        if (triSE) {
            driver.findElement(By.xpath("//div[contains(@id,'ajaxTriState')]//div[contains(@class,'ui-chkbox-box')]"))
                    .click();
        }
        // boolean triSS =
        // driver.findElement(By.xpath("//input[contains(@id,'ajaxTriState_input')]/following::div/span[contains(@class,'ui-chkbox-icon')]")).isSelected();
        // System.out.println("Selected status of the checkbox: " + triSS);
        // WebElement element =
        // driver.findElement(By.xpath("//input[contains(@id,'ajaxTriState_input')]/following::div/span[contains(@class,'ui-chkbox-icon')]"));
        // String classValue = element.getDomAttribute("class");

        String text = driver.findElement(By.xpath("//span[contains(text(),'State ')]/parent::div")).getText();
        if (text.contains("State = 1")) {
            System.out.println("Tri-State option 1 has been chosen");
        } else if (text.contains("State = 2")) {
            System.out.println("Tri-State option 2 has been chosen");
        } else {
            System.out.println("Tri-State option 3 has been chosen");
        }

        driver.findElement(By.className("ui-toggleswitch-slider")).click();
        String status2 = cb.checkboxStatus(msg);
        System.out.println("Toggleswitch slider status is " + status2);

        // Verify if checkbox is disabled
        boolean checkStatus = driver
                .findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div/input[@type='checkbox']"))
                .isEnabled();
        if (checkStatus) {
            System.out.println("Checkbox is Enabled");
        } else {
            System.out.println("Checkbox is Disabled");
        }

        // Select multiple options
        driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-multiple-container')]")).click();
        driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("Lon");
        driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div[contains(@class,'ui-chkbox')]"))
                .click();
        driver.findElement(By.xpath("//input[@role='textbox']")).clear();
        driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("pa");
        driver.findElement(By.xpath("//label[text()='Paris']/preceding-sibling::div[contains(@class,'ui-chkbox')]"))
                .click();
        driver.findElement(By.xpath("//a[@aria-label='Close']")).click();

        Thread.sleep(3000);
        driver.close();
    }

}
