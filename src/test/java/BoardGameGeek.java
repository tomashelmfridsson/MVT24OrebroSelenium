import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardGameGeek {

    @Test

    public void testGoogleSearch(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.boardgamegeek.com/");
        driver.findElement(By.className("fc-button-label")).click();
        driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Things in Rings", Keys.ENTER);
        driver.findElement(By.cssSelector("a.primary")).click();
        driver.findElement((By.cssSelector("[href=\"/boardgame/408547/things-in-rings/videos/all\"]"))).click();
        assertEquals("Things in Rings | Board Game | BoardGameGeek",driver.getTitle());
        driver.quit();
    }

}
