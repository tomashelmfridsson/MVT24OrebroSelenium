import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoardGameGeek {

    @Test

    public void testGoogleSearch() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.boardgamegeek.com/");
        driver.findElement(By.cssSelector(".fc-button-label")).click();


        // driver.quit();

    }

}
