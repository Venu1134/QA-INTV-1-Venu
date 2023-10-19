package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRatings {
    ChromeDriver driver;

    public IMDBRatings() {
        System.out.println("Start Test : IMDB Ratings");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void endTest() {
        System.out.println("End Test : IMDB Ratings");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        // Navigate to imdb website https://www.imdb.com/chart/top/
        // Click on the sort by dropdown Using Locator "ID" sort-by-selector
        // Get the List of dropdown values Using Locator "XPath"
        // //select[@id='sort-by-selector']//option
        // Iterate over all dropdown values //select[@id='sort-by-selector']//option
        // Click on the option if dropdown value matches with the text. Using Locator
        // "XPath" //select[@id='sort-by-selector']//option | expectedVaue = 'IMDB
        // Ratings'
        // Get the text of highest rated movie Using Locator "XPath"
        // (//a[contains(@class,'ipc-title')])[1]
        // Print the highest rated movie name
        // Get the total movies in table Using Locator "XPath"
        // //ul[@role='presentation']//a[contains(@class,'ipc-title')]
        // Print the total movies in table
        // Click on the sort by dropdown Using Locator "ID" sort-by-selector
        // Get the List of dropdown values Using Locator "XPath"
        // //select[@id='sort-by-selector']//option
        // Iterate over all dropdown values for(int i=0; i<size; i++)
        // Click on the option if dropdown value matches with the text.
        // //select[@id='sort-by-selector']//option | expectedVaue = 'Release date'
        // Get the text of oldest movie on the list Using Locator "XPath"
        // (//a[contains(@class,'ipc-title')])[250]
        // Print the oldest movie name
        // Get the text of most recent movie on the list Using Locator "XPath"
        // (//a[contains(@class,'ipc-title')])[1]
        // Print the name of most recent movie on the list
        // Click on the sort by dropdown Using Locator "ID" sort-by-selector
        // Get the List of dropdown values Using Locator "XPath"
        // //select[@id='sort-by-selector']//option
        // Iterate over all dropdown values
        // Click on the option if dropdown value matches with the text.
        // //select[@id='sort-by-selector']//option | expectedVaue = 'Number of ratings'
        // Get the text of movie has the most user ratings Using Locator "XPath"
        // (//a[contains(@class,'ipc-title')])[1]
        // Print the movie name that has most user ratings

        driver.get("https://www.imdb.com/chart/top");
        driver.findElement(By.id("sort-by-selector")).click();
        List<WebElement> sortBy = driver.findElements(By.xpath("//select[@id='sort-by-selector']//option"));
        for (int i = 0; i < sortBy.size(); i++) {
            String actualSortByOptions = sortBy.get(i).getText();
            if (actualSortByOptions.equalsIgnoreCase("IMDB Ratings")) {
                sortBy.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        String highestRatedMovie = driver.findElement(By.xpath("(//a[contains(@class,'ipc-title')])[1]")).getText();
        System.out.println("the highest rated movie on IMDb is " + highestRatedMovie);

        List<WebElement> movieList = driver
                .findElements(By.xpath("//ul[@role='presentation']//a[contains(@class,'ipc-title')]"));
        int totalMoviesInTable = movieList.size();
        System.out.println("Total movies are included in the table" + totalMoviesInTable);

        driver.findElement(By.id("sort-by-selector")).click();
        for (int i = 0; i < sortBy.size(); i++) {
            String actualSortByOptions = sortBy.get(i).getText();
            if (actualSortByOptions.equalsIgnoreCase("Release date")) {
                sortBy.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        String oldestMovie = driver.findElement(By.xpath("(//a[contains(@class,'ipc-title')])[250]")).getText();
        System.out.println("The oldest movie on the list is " + oldestMovie);

        String recentMovie = driver.findElement(By.xpath("(//a[contains(@class,'ipc-title')])[1]")).getText();
        System.out.println("The most recent movie on the list is " + recentMovie);

        driver.findElement(By.id("sort-by-selector")).click();
        for (int i = 0; i < sortBy.size(); i++) {
            String actualSortByOptions = sortBy.get(i).getText();
            if (actualSortByOptions.equalsIgnoreCase("Number of ratings")) {
                sortBy.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        String mostUserRatings = driver.findElement(By.xpath("(//a[contains(@class,'ipc-title')])[1]")).getText();
        System.out.println("The movie has the most user ratings is " + mostUserRatings);
    }
}
