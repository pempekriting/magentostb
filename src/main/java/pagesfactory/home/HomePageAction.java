package pagesfactory.home;

import context.TestContext;
import org.openqa.selenium.WebElement;

public class HomePageAction extends HomePage {
    public HomePageAction(TestContext context) {
        super(context);
    }

    public void goToLoginPage() {
        signInMenu.click();
    }

    public HomePageAction hoverNavigationMenu(String menuName) {
        hoverObject(getMenuObject(menuName));
        return this;
    }

    public HomePageAction hoverNavigationMenu(String menuName, String additionalIdentifier) {
        hoverObject(getMenuObject(menuName, additionalIdentifier));
        return this;
    }

    public void clickNavigationMenu(String menuName) {
        getMenuObject(menuName).click();
    }

    public void clickNavigationMenu(String menuName, String additionalIdentifier) {
        getMenuObject(menuName, additionalIdentifier).click();
    }

    WebElement getMenuObject(String menuName) {
        return findElement("//a[contains(@href,'.html')]/span[text()='" + menuName + "']");
    }

    WebElement getMenuObject(String menuName, String additionalIdentifier) {
        return findElement("//a[contains(@href,'" + additionalIdentifier + ".html')]/span[text()='" + menuName + "']");
    }
}
