package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleNameLinks {

    ChromeDriver driver;

    public GoogleNameLinks() {
        System.out.println("Start Test : Google Name Links");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Google Name Links");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        // Navigate to google.com google.com
        // Enter text in search field Using Locator "ID" APjFqb | Sendkeys('Venugopal')
        // Click on google search button Using Locator "XPath"
        // (//input[@name='btnK'])[2]
        // Get the count of all links which contains "Venugopal" Using Locator "XPath"
        // (//input[@name='btnK'])[2]
        // Print the count of links

        String stringValue = "Venugopal";
        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys(stringValue);
        driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();
        Thread.sleep(3000);
        int allLinksCount = driver.findElements(By.xpath("//h3[contains(text(),'" + stringValue + "')]")).size();
        System.out.println("the count of all links which contains Venugopal is " + allLinksCount);
    }
}
