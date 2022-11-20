package pagesfactory;

import com.github.javafaker.Faker;
import context.TestContext;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class BasePage {
    final WebDriverWait wait;
    final WebDriver driver;
    final Actions actions;
    static final Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(10);
    static final Duration POLLING_TIME = Duration.ofMillis(1);

    public final SecureRandom random = new SecureRandom();

    public final Faker faker = new Faker();

    public BasePage(TestContext context) {
        wait = context.driverWait;
        driver = context.driver;
        actions = new Actions(driver);
        PageFactory.initElements(context.driver, this);
    }

    public FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(getDriver())
                .withTimeout(EXPLICIT_TIMEOUT)
                .pollingEvery(POLLING_TIME)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }

    public String getValueAttribute(WebElement webElement, String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    public void scrollToElement(WebElement element) {
        actions.scrollToElement(element).perform();
    }

    public void hoverObject(WebElement element) {
        fluentWait().until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();

    }

    public WebElement findElement(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public List<WebElement> findElements(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    public int randomNumber(int max, int min) {
        return random.nextInt(max - min + 1) + min;
    }

    public void waitABit(int second) {
        try {
            Thread.sleep(Duration.ofSeconds(second).toMillis());
        } catch (InterruptedException ignored) {

        }
    }

    public Select findSelect(WebElement element) {
        return new Select(element);
    }
}