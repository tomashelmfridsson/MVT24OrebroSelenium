import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectBoardGameGeek {
    private WebDriver driver = new ChromeDriver();
    public WebElement searchButton = driver.findElement(By.cssSelector("input.form-control.ng-untouched"));
}
