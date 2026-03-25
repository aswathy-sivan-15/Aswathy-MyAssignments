package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeContacts {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(opt);
        // Load URL
        driver.get("http://leaftaps.com/opentaps/control/login");
        // maximize window
        driver.manage().window().maximize();
        // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Login
        driver.findElement(By.id("username")).sendKeys("democsr");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        // Navigate to Merge Contacts
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.partialLinkText("Merge")).click();

        // Click From Contact Widget
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        Thread.sleep(2000);
        // Handle window
        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windows);
        // Switch to new window
        driver.switchTo().window(windowList.get(1));
        // Select first contact
        driver.findElement(By.linkText("DemoCustomer")).click();
        // Switch back to parent
        driver.switchTo().window(windowList.get(0));

        // Click From Contact Widget
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        // Handle window
        Thread.sleep(2000);

        Set<String> windows1 = driver.getWindowHandles();
        List<String> windowList1 = new ArrayList<>(windows1);
        // Switch to new window
        driver.switchTo().window(windowList1.get(1));
        // Select second contact
        driver.findElement(By.linkText("DemoLBCust")).click();
        // switch back to parent
        driver.switchTo().window(windowList1.get(0));
        // click on merge button
        driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
        Thread.sleep(2000);
        // Accept the alert
        driver.switchTo().alert().accept();

        //  Explicit wait for title
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.titleContains("Merge Contacts"));

        // verify the title
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        if (title.contains("Merge Contacts")) {
            System.out.println("Title verified successfully");
        } else {
            System.out.println("Title verfication failed");
        }

        driver.quit();
    }

}
