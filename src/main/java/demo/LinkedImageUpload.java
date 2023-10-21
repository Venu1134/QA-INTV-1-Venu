package demo;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedImageUpload {
    ChromeDriver driver;

    public LinkedImageUpload() {
        System.out.println("Start Test : Linkedin Image Upload");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Linkedin Image Upload");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException, AWTException {
        // Navigate to linkedin linkedin.com
        // Enter text in email or phone text field Using Locator "ID" username |
        // Sendkeys('venugopal@gmail.com')
        // Enter text in password text field Using Locator "ID" password |
        // Sendkeys('Venu@1134')
        // Click on the sign in button Using Locator "XPath" password |
        // Sendkeys('Venu@1134')
        // Wait until home page is displayed 5000
        // Click on start a post Using Locator "XPath"
        // //div[contains(@class,'top-bar')]//button
        // Click on Add media buuton Using Locator "XPath" (//button[@aria-label='Add
        // media']//span)[1]
        // Enter the path of the file in window pop-up path =
        // "C:\Users\Dell\Videos\Captures\mSeva - Google Chrome 2023-10-11 09-54-06.mp4"
        // Click on open in window pop-up
        // Click on next button Using Locator "XPath" //span[text()='Next']
        // Click on post button Using Locator "XPath" //span[text()='Post']
        // Verify post is posted successfully Using Locator "XPath"
        // //p[@role='alert']//span

        driver.get("https://www.linkedin.com/uas/login");
        driver.findElement(By.id("username")).sendKeys("venugopal281999@gmail.com");
        driver.findElement(By.id("password")).sendKeys("venu1234");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class,'top-bar')]//button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@aria-label='Add media']//span)[1]")).click();

        // StringSelection selection = new
        // StringSelection("C:\\Users\\Dell\\Downloads\\Applications by Source.jpeg");
        // Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
        // null);

        // Robot robot = new Robot();
        // robot.keyPress(KeyEvent.VK_CONTROL);
        // robot.keyPress(KeyEvent.VK_V);
        // robot.keyRelease(KeyEvent.VK_V);
        // robot.keyRelease(KeyEvent.VK_CONTROL);
        // robot.keyPress(KeyEvent.VK_ENTER);
        // robot.keyRelease(KeyEvent.VK_ENTER);
        // Thread.sleep(3000);

        String filePath = "C:\\Users\\Dell\\Downloads\\Applications by Source.jpeg";
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(filePath);

        driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        driver.findElement(By.xpath("//p[@role='alert']//span")).isDisplayed();
    }
}
