package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
    ChromeDriver driver;

    public WindowHandles() {
        System.out.println("Start Test : Window Handles");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : window Handles");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        String newWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(newWindow)) {
                driver.switchTo().window(windowHandle);
                String newWindowURL = driver.getCurrentUrl();
                System.out.println("URL of new window is : " + newWindowURL);
                String newWindowTitle = driver.getTitle();
                System.out.println("Title of new window is : " + newWindowTitle);

                LocalTime currentTime = LocalTime.now();
                String formattedTime = currentTime.toString().replace(":", "_");
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
                File desPath = new File(System.getProperty("user.dir") + "//screenshots//new_Window-Screenshots");
                desPath.mkdirs();

                File destFile = new File(desPath, "screenshot_" + formattedTime + ".png");
                try {
                    FileUtils.copyFile(srcFile, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                driver.close();
            }
        }

        driver.switchTo().window(newWindow);
    }
}
