package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesText {
    ChromeDriver driver;

    public FramesText() {
        System.out.println("Start Test : Frames Text");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Frames Text");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
        System.out.println("Text in left frame : " + leftText);
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        String rightText = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
        System.out.println("Text in right frame : " + rightText);
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
        System.out.println("Text in middle frame : " + middleText);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-bottom");
        String bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
        System.out.println("Text in bottom frame : " + bottomText);
        driver.switchTo().parentFrame();
    }
}
