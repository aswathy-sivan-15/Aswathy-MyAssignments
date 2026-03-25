package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAlertInteractions {
   public static void main(String[] args) {
      // Precondition
      WebDriver driver = new ChromeDriver();
      driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      // Switch to frame
      driver.switchTo().frame("iframeResult");
      // Click "Try it" button
      driver.findElement(By.xpath("//button[text()='Try it']")).click();
      // Handle alert
      Alert alert1 = driver.switchTo().alert();
      // Click OK in the alert appears and verify the text to confirm the correct
      // action is performed
      alert1.accept();
      String actualOkMsg = driver.findElement(By.id("demo")).getText();
      String expectedOkMsg = "You pressed OK!";
      if (expectedOkMsg.equals(actualOkMsg)) {
         System.out.println("PASS! Expected msg is dispalyed " + actualOkMsg);
      } else {
         System.out.println("FAIL! Message displayed is not expected " + actualOkMsg);
      }
      //

      // Click cancel in the alert appears and verify the text to confirm the correct
      // action is performed
      driver.findElement(By.xpath("//button[text()='Try it']")).click();
      Alert alert2 = driver.switchTo().alert();
      alert2.dismiss();
      String actualCancelMsg = driver.findElement(By.id("demo")).getText();
      String expectedCancelMsg = "You pressed Cancel!";

      if (expectedCancelMsg.equals(actualCancelMsg)) {
         System.out.println("PASS! Expected msg is dispalyed " + actualCancelMsg);
      } else {
         System.out.println("FAIL! Message displayed is not expected " + actualCancelMsg);
      }
      driver.quit();
   }

}
