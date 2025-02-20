import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardGameGeekTest {
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
    public static void tearDown() {
        driver.quit();
    }

    // @Test // Sök spel och assert på titel
    public void testThingsInRings() {
        // driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Things in Rings", Keys.ENTER);
        driver.findElement(By.cssSelector("input.form-control.ng-untouched"))  //input.form-control.ng-pristine.ng-valid.ng-touched"))
                .sendKeys("Things in rings", Keys.ENTER);
        //driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Things in Rings", Keys.ENTER);
        driver.findElement(By.cssSelector("a.primary")).click();
        driver.findElement((By.cssSelector("[href=\"/boardgame/408547/things-in-rings/videos/all\"]"))).click();
        assertEquals("Things in Rings | Board Game | BoardGameGeek", driver.getTitle());
    }

    // @Test // Visa alla familjespel
    public void testFamiliesGames() throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("input[id='1']"));
        WebElement search2 = driver.findElement(By.cssSelector("input#\\31"));
        driver.findElement(By.cssSelector("input.form-control.ng-untouched"))  //input.form-control.ng-pristine.ng-valid.ng-touched"))
                .sendKeys("Things in rings", Keys.ENTER);
        driver.findElement(By.cssSelector("a.primary")).click();


        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".hidden-xs .buy-btn-text")));
//        WebElement buy = driver.findElement(By.cssSelector(".hidden-xs .buy-btn-text"));

        //WebElement buy = driver.findElement(By.cssSelector(".visible-xs .buy-btn-text"));
        WebElement buy = driver.findElement(By.cssSelector(".buy-btn.btn.btn-sm.ng-scope"));

        System.out.println(buy.isDisplayed());
        System.out.println(buy.isEnabled());
        List<WebElement> elements = driver.findElements(By.cssSelector(".buy-btn"));
        for (WebElement element : elements) {
            System.out.println(elements);
            System.out.println(element.getDomAttribute("class"));
            System.out.println(getElementXPath(driver, element));
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }
        // buy.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element =
//                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buy-btn-text")));
//       element.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".hidden-xs .buy-btn-text")));
//        driver.findElement(By.cssSelector(".hidden-xs .buy-btn-text")).click();
//        driver.findElement(By.cssSelector("[alt=\"Things in Rings Cover Artwork\"]")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement buyButton =
//                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".visible-xs .buy-btn")));
//        buyButton.click();
        //driver.findElement(By.cssSelector("body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button > p")).click();

        //driver.findElement(By.cssSelector("#results_objectname1 > a")).click();

        //driver.findElement(By.cssSelector("#primary_tabs > ul > li:nth-child(4) > a")).click();
        //driver.findElement(By.cssSelector("#mainbody > div.global-body-content-container.container-fluid > div > div.content.ng-isolate-scope > div:nth-child(2) > ng-include > div > ng-include > div > div.game-header > div.game-header-body > div.game-header-primary-actions.hidden-game-header-collapsed > span.visible-xs > ng-include > div.toolbar-actions-mobile.toolbar-actions-mobile-lg.ng-scope > div:nth-child(1) > a")).click();
        // Funkar
        // driver.findElement(By.xpath("//*[@id=\"mainbody\"]/div[2]/div/div[2]/div[2]/ng-include/div/ng-include/div/div[2]/div[2]/div[4]/span[3]/ng-include/div/div[1]/a")).click();
        // driver.findElement(By.cssSelector("#mainbody > div.global-body-content-container.container-fluid > div > div.content.ng-isolate-scope > div:nth-child(2) > ng-include > div > ng-include > div > div.game-header > div.game-header-body > div.game-header-primary-actions.hidden-game-header-collapsed > span:nth-child(3) > ng-include > div > div:nth-
    }

    @Test
    public void listElement() {
//        driver.findElement(By.cssSelector("input.form-control.ng-untouched"))  //input.form-control.ng-pristine.ng-valid.ng-touched"))
//                .sendKeys("Things in rings", Keys.ENTER);
        PageObjectBoardGameGeek page = new PageObjectBoardGameGeek();
        page.searchButton.sendKeys("Things in rings", Keys.ENTER);
        driver.findElement(By.cssSelector("a.primary")).click();
        List<WebElement> buyButtons = driver.findElements(By.cssSelector(".buy-btn"));
        System.out.println(buyButtons.size());
        for (WebElement element : buyButtons) {
            System.out.println(element.isDisplayed());
            System.out.println(getElementXPath(driver, element));
        }
    }

    // @Test
    public void hrefList(){
        List<WebElement> hrefs = driver.findElements(By.cssSelector("[href]"));
        System.out.println(hrefs.size());
        for (WebElement element: hrefs){
            System.out.println(element.getDomAttribute("href"));
        }
    }


    public String getElementXPath(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String xpath = (String) js.executeScript(
                "function absoluteXPath(element) {" +
                        "  var comp, comps = [];" +
                        "  var parent = null;" +
                        "  var xpath = '';" +
                        "  var getPos = function(element) {" +
                        "    var position = 1, curNode;" +
                        "    for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {" +
                        "      if (curNode.nodeName == element.nodeName) {" +
                        "        ++position;" +
                        "      }" +
                        "    }" +
                        "    return position;" +
                        "  };" +
                        "  if (element instanceof Document) {" +
                        "    return '/';" +
                        "  }" +
                        "  for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {" +
                        "    comp = {};" +
                        "    switch (element.nodeType) {" +
                        "      case Node.TEXT_NODE:" +
                        "        comp.name = 'text()';" +
                        "        break;" +
                        "      case Node.ATTRIBUTE_NODE:" +
                        "        comp.name = '@' + element.nodeName;" +
                        "        break;" +
                        "      case Node.ELEMENT_NODE:" +
                        "        comp.name = element.nodeName;" +
                        "        break;" +
                        "    }" +
                        "    comp.position = getPos(element);" +
                        "    comps.push(comp);" +
                        "  }" +
                        "  for (var i = comps.length - 1; i >= 0; i--) {" +
                        "    comp = comps[i];" +
                        "    xpath += '/' + comp.name.toLowerCase();" +
                        "    if (comp.position !== null) {" +
                        "      xpath += '[' + comp.position + ']';" +
                        "    }" +
                        "  }" +
                        "  return xpath;" +
                        "}" +
                        "return absoluteXPath(arguments[0]);", element);
        return xpath;
    }

}

