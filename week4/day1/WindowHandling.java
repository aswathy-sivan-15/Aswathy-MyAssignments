package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.irctc.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//label[text()='FLIGHTS']/parent::a")).click();
        // Get all window handles
        Set<String> windows = driver.getWindowHandles();
        // Convert Set to List (to use index)
        List<String> windowList = new ArrayList<>(windows);
        // Switch to new window (Flights window)
        driver.switchTo().window(windowList.get(1));
        // Capture and print title
        System.out.println("Flights Page Title: " + driver.getTitle());
        // Switch back to parent window
        driver.switchTo().window(windowList.get(0));
        // Close parent tab
        driver.close();

    }

}
