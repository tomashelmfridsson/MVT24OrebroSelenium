
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class EBayTest {

    private static WebDriver driver;


    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        // driver.quit();
    }

    @BeforeEach
    public void reset() throws InterruptedException {
        driver.get("https://ebay.com/");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gdpr-banner-accept")));
        Thread.sleep(3000);
        driver.findElement(By.id("gdpr-banner-accept")).click();
    }


    @Test
    public void searchArt(){
        Select select = new Select(driver.findElement(By.cssSelector("select#gh-cat")));
        //select.selectByIndex(2);
        select.selectByVisibleText("Art");
        driver.findElement(By.cssSelector("input#gh-ac")).sendKeys("van Gogh");
        driver.findElement(By.cssSelector("button#gh-search-btn")).click();


    }
}
