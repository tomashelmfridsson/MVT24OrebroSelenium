import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardGameGeek {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("http://www.boardgamegeek.com/");
        driver.findElement(By.className("fc-button-label")).click();
    }

    @BeforeEach
    public void reset() {
        driver.get("http://www.boardgamegeek.com/");
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test // Sök spel och assert på titel
    public void testThingsInRings() {
        // driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Things in Rings", Keys.ENTER);
        driver.findElement(By.cssSelector("input.form-control.ng-untouched"))  //input.form-control.ng-pristine.ng-valid.ng-touched"))
                .sendKeys("Things in rings", Keys.ENTER);
        //driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Things in Rings", Keys.ENTER);
        driver.findElement(By.cssSelector("a.primary")).click();
        driver.findElement((By.cssSelector("[href=\"/boardgame/408547/things-in-rings/videos/all\"]"))).click();
        assertEquals("Things in Rings | Board Game | BoardGameGeek", driver.getTitle());
    }

    @Test // Visa alla familjespel
    public void testFamiliesGames(){
        WebElement search = driver.findElement(By.cssSelector("input[id='1']"));
        WebElement search2 = driver.findElement(By.cssSelector("input#\\31"));
    }
}
