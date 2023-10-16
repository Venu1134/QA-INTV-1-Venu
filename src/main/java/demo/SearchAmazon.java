package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon() {
        System.out.println("Start Test : SearchAmazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Search Amazon");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        String stringValue = "Amazon.in";

        // Navigate to google google.com
        // Wait until search bar is displayed 2000
        // Enter text in search field Using Locator "ID" APjFqb | Sendkeys('amazon')
        // Click on "Googl Search" button Using Locator "XPath"
        // (//input[@name='btnK'])[1]
        // Wait until search results displayed 3000
        // Verify "amazon.in" or "amazon.com" is displayed Using Locator "XPath"
        // //h3[text()='+stringValue+' or text()='+stringValue+'] | stringValue =
        // "Amazon.in" or "Amazon.com"

        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("APjFqb")).sendKeys("amazon");
        driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();
        Thread.sleep(2000);
        boolean status = driver
                .findElement(By.xpath("//h3[text()='" + stringValue + "' or text()='" + stringValue + "']"))
                .isDisplayed();
        if (status == true) {
            System.out.println("Search Amazon : PASSED");
        } else {
            System.out.println("Search Amazon : FAILED");
        }
    }
}
