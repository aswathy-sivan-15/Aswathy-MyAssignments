package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInteractions {
    public static void main(String[] args) {
        // Precondition
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Click on the "Prompt Box" button
        driver.findElement(By.xpath("//h5[contains(text(),'Prompt')]/following-sibling::button")).click();
        // Switch to the alert and type a message in the alert box
        Alert alert = driver.switchTo().alert();
        String inputText = "Selenium";
        alert.sendKeys(inputText);
        String alertMsg = alert.getText();
        System.out.println("Alert message is: " + alertMsg);
        // Dismiss the alert.
        alert.dismiss();
        // Get result text from page
        String resultText = driver.findElement(By.id("confirm_result")).getText();
        System.out.println("Result: " + resultText);
        // Validation
        if (resultText.contains(inputText)) {
            System.out.println("PASS: Entered text is reflected correctly");
        } else {
            System.out.println("FAIL: Entered text is NOT reflected");
        }
        driver.quit();

    }

}
