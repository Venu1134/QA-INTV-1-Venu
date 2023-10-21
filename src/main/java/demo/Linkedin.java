package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin {
    ChromeDriver driver;

    public Linkedin() {
        System.out.println("Start Test : Linkedin post");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Linkedin post");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        // Navigate to linkedin linkedin.com
        // Enter text in email or phone text field Using Locator "ID" username |
        // Sendkeys('venugopal@gmail.com')
        // Enter text in password text field Using Locator "ID" password |
        // Sendkeys('Venu@1134')
        // Click on the sign in button Using Locator "XPath" password |
        // Sendkeys('Venu@1134')
        // Wait until home page is displayed 5000
        // Using get text get total number of Who viewed your profile Using Locator
        // "XPath" (//div[contains(@class,'baseline')]//Strong)[1]
        // Print Total number of Who viewed your profile
        // Using get text get total number of Impressions of your post Using Locator
        // "XPath" (//div[contains(@class,'baseline')]//Strong)[2]
        // Print Total number of Impressions of your post
        // Click on start a post Using Locator "XPath"
        // //div[contains(@class,'top-bar')]//button
        // Enter text in message space Using Locator "XPath"
        // //div[contains(@data-placeholder,'What do you want to talk about?')] |
        // Sendkeys('The art of software testing is to identify the pain points and
        // ensure that the application heals and grows from them.')
        // Click on profile name to change post settings Using Locator "XPath"
        // //div[contains(@class,'lockup__title')]
        // Click on connections only post settings. Using Locator "ID" CONNECTIONS_ONLY
        // Click on done button to reflect post settings Using Locator "XPath"
        // //span[text()='Done']
        // Click on post button Using Locator "XPath" //span[text()='Post']
        // Verify post is posted successfully Using Locator "XPath"
        // //p[@role='alert']//span

        String message = "'You can't control every aspect of the software development process, but you can control the quality of your code through testing.'";

        driver.get("https://www.linkedin.com/uas/login");
        driver.findElement(By.id("username")).sendKeys("venugopal28@gmail.com");
        driver.findElement(By.id("password")).sendKeys("venu1234");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(5000);
        String profileViewers = driver.findElement(By.xpath("(//div[contains(@class,'baseline')]//Strong)[1]"))
                .getText();
        System.out.println("Total number of Who viewed your profile is " + profileViewers);
        String postImpressions = driver.findElement(By.xpath("(//div[contains(@class,'baseline')]//Strong)[2]"))
                .getText();
        System.out.println("Total number of Impressions of your post is " + postImpressions);
        driver.findElement(By.xpath("//div[contains(@class,'top-bar')]//button")).click();
        driver.findElement(By.xpath("//div[contains(@class,'lockup__title')]")).click();
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        driver.findElement(By.xpath("//div[contains(@data-placeholder,'What do you want to talk about?')]"))
                .sendKeys(message);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        driver.findElement(By.xpath("//p[@role='alert']//span")).isDisplayed();
    }
}
