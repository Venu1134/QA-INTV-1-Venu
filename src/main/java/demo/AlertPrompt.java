package demo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPrompt {

    ChromeDriver driver;

    public AlertPrompt() {
        System.out.println("Start Test : Alert Prompt");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Alert Prompt");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        // Navigate to alerts web page
        // https://web-locators-static-site-qa.vercel.app/Alerts
        // Click on "Add Remarks" button Using Locator "XPath" //p[contains(text(),'Add
        // Remarks')]
        // Switch to alert using driver.switchTo().alert();
        // Enter the text Using Sendkeys("Venu gopal")
        // Accept the alert using alert.accept();
        // Get the text Using Locator "XPath" //p[@class='Alert_remarkContent']
        // Verify entered text is same as displayed text

        String expectedString = "VenuGopal";
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
        driver.findElement(By.xpath("//p[contains(text(),'Add Remarks')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(expectedString);
        alert.accept();
        String actualString = driver.findElement(By.xpath("//p[@class='Alert_remarkContent']")).getText();
        if (actualString.equals(expectedString)) {
            System.out.println("Alert Prompt Test case : PASSED");
        } else {
            System.out.println("Alert Prompt Test case : FAILED");
        }
    }
}
