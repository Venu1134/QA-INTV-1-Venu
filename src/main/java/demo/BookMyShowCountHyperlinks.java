package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShowCountHyperlinks {
    ChromeDriver driver;

    public BookMyShowCountHyperlinks() {
        System.out.println("Start Test : BookMyShow count hyperlinks");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : BookMyShow count hyperlinks");
        driver.close();
        driver.quit();
    }

    public void testCase01() {

        // Navigate to bookmyshow bookmyshow.com
        // Get the count of hyperlinks Using Locator "XPath" //a[@href]
        // Print the count

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> hyperLinks = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("Total count of hyperLinks is " + hyperLinks.size());

    }
}
