package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageURLs {
    ChromeDriver driver;

    public ImageURLs() {
        System.out.println("Start Test : Image URLs");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : Image URLs");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        // Navigate to bookmyshow bookmyshow.com
        // Get the size of image url's using find elements Using Locator "XPath"
        // //div[contains(@class,'iUlTEb')]//img
        // Iterate through each element and get the image using get attribute
        // getAttribute('src')
        // Print the each image url getAttribute('src')
        // Scroll down to premieres Using Locator "XPath" //h2[text()='Premieres']
        // Get the Name & Language of the 2nd item in the “Premiere” list Using Locator
        // "XPath"
        // (//div[contains(@class,'hpUsIF')]//div[contains(@class,'cZuToi')])[2]
        // Print the Name & Language of the 2nd item in the “Premiere” list

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(3000);
        List<WebElement> recommendedImageElements = driver
                .findElements(By.xpath("//div[contains(@class,'iUlTEb')]//img"));
        for (int i = 0; i < recommendedImageElements.size(); i++) {
            String imageURL = recommendedImageElements.get(i).getAttribute("src");
            System.out.println("Recommended Image URL : " + imageURL);
        }

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'gXVNQI')])[1]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement recommendedMovies = driver.findElement(By.xpath("(//div[contains(@class,'dCXGzT')])[2]"));
        js.executeScript("arguments[0].scrollIntoView();", recommendedMovies);

        WebElement streamAd = driver.findElement(By.xpath("(//div[contains(@class,'dCXGzT')])[3]"));
        js.executeScript("arguments[0].scrollIntoView();", streamAd);

        Thread.sleep(5000);

        WebElement liveEvents = driver.findElement(By.xpath("(//div[contains(@class,'gXVNQI')])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", liveEvents);

        WebElement Premieres = driver.findElement(By.xpath("//h2[text()='Premieres']"));
        js.executeScript("arguments[0].scrollIntoView();", Premieres);

        String secondMovieNameandLanguage = driver
                .findElement(By.xpath("(//div[contains(@class,'hpUsIF')]//div[contains(@class,'cZuToi')])[2]"))
                .getText();
        System.out.println("Second movie name and language is " + secondMovieNameandLanguage);
    }
}
