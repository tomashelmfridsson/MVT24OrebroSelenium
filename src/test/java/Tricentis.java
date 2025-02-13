
import org.junit.After;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.jupiter.api.Test; //JUnit5

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarOutputStream;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.*;

public class Tricentis {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void reset() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Ignore("Testen är inaktiverad för tillfället")
    //@Test
    public void testTricentis() {
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        WebElement booksLink = driver.findElement(By.xpath(
                "/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a"));
        WebElement welcomeText = driver.findElement(By.cssSelector(".topic-html-content-title"));

        assertEquals("Register", registerLink.getText());
        assertEquals("Books", booksLink.getText());
        assertEquals("Welcome to our store", welcomeText.getText());

    }

    // Navigera till sidan: https://demowebshop.tricentis.com/register
    // Fyll i registreringsformuläret
    // Kontrollera att du hamnar på en bekräftelsesida eller får ett meddelande som säger att kontot skapades.
    @Ignore("Testen är inaktiverad för tillfället")
    //@Test
    public void searchComputingAndInternet() {
        WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchBoxButton = driver.findElement(By.className("search-box-button"));
        searchField.sendKeys("Computing and Internet");
        searchBoxButton.click();
        WebElement searchResult = driver.findElement(By.className("product-title"));
        assertEquals("Computing and Internet", searchResult.getText());
    }

    // Navigera till sidan: https://demowebshop.tricentis.com/register
    // Fyll i registreringsformuläret
    // Kontrollera att du hamnar på en bekräftelsesida eller får ett meddelande som säger att kontot skapades.
    //@Test
    public void register() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).isSelected();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("Testsson");
        driver.findElement(By.id("Email")).sendKeys("tomastestgubbe" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("abc123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
        driver.findElement(By.id("register-button")).click();
        assertEquals("Your registration completed", driver.findElement(By.className("result")).getText());
    }

    //Navigera till en produktkategori, t.ex. "Books".
    //Hämta priset för alla produkter i kategorin och kontrollera
    // att de ligger inom ett rimligt intervall (t.ex. 0–500).
    //@Test
    public void getPrices() {
        driver.findElement(By.linkText("Books")).click();
        List<WebElement> books = driver
                .findElements(By.className("product-item"));
        System.out.println(books.size());
        for (WebElement book : books) {
            String text = book.getText();
            String[] textArray = text.split("\n");
            // System.out.println(Arrays.toString(textArray));
            double price = parseDouble(textArray[2]);
            assertTrue(0 < price && price < 500);
        }
    }

    // Navigera till inloggningssidan: https://demowebshop.tricentis.com/login
    // Logga in med ett testkonto. tomastestgubbe@gmail.com
    // Verifiera att du är inloggad
    // Logga ut och verifiera att du är utloggad
    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("tomastestgubbe@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("abc123");
        driver.findElement(By.className("login-button")).click();
        assertEquals("tomastestgubbe@gmail.com",
                driver.findElement(By.className("account")).getText());
        driver.findElement(By.linkText("Log out")).click();
        assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());
    }

}
