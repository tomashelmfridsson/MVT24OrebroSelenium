import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

// import org.junit.Test;   // Junit4
import org.junit.jupiter.api.Test; //JUnit5
public class Google {

    @Test

    public void testGoogleSearch() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");
        //driver.get("http://www.duckduckgo.com/");
        Thread.sleep(5000);  // Let the user actually see something!

        WebElement buttonAccept = driver.findElement(By.id("L2AGLb"));
        buttonAccept.click();

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("ChromeDriver");

        searchBox.submit();

        Thread.sleep(5000);  // Let the user actually see something!

        // driver.quit();

    }

}
