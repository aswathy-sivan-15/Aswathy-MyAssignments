package week3.day2.assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import week1.day2.Firefox;

public class RadioButtonInteraction {
  public static void main(String[] args) {
    // Launch the browser
    FirefoxDriver driver = new FirefoxDriver();
    // Load the URL
    driver.navigate().to("https://www.leafground.com/radio.xhtml");
    // implicit wait
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    // maximize the browser
    driver.manage().window().maximize();

    // Select 'Your most favourite browser'
    driver.findElement(By.xpath("(//label[text()='Chrome']/preceding-sibling::div)[1]")).click();
    // Click radio button and verify unselected
    WebElement bengaluru = driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding-sibling::div"));
    bengaluru.click();
    // click again
    bengaluru.click();
    // verify selection
    System.out.println("Is Bengaluru selected: " + bengaluru.isSelected());
    // Identify the radio button that is initially selected by default
    driver.navigate().refresh();
    List<WebElement> radioBtns = driver.findElements(By.xpath("//div[contains(@class,'ui-state-active')]"));
    System.out.print("Default selected radio buttons : ");
    for (WebElement radio : radioBtns) {

      String label = radio.findElement(By.xpath("./parent::div/following-sibling::label")).getText();
      if (!label.isEmpty()) {
        System.out.print(label + "  ");

      }

    }
    // Check and select the age group (21-40 Years) if not already selected
    WebElement ageRadio = driver.findElement(By.xpath("//input[@value='21-40 Years']/parent::div/following-sibling::div"));
    String atrValue = ageRadio.getDomAttribute("class");
    if (atrValue.contains("active")) {
      System.out.println("\nThe age group (21-40 Years) is already selected");
    } 
    else {
      driver.findElement(By.xpath("//input[@value='21-40 Years']/parent::div/following-sibling::div")).click();
      
    }

    driver.close();

  }

}
