package pagesfactory.home;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesfactory.BasePage;

public class HomePage extends BasePage {

    @FindBy(className = "authorization-link")
    WebElement signInMenu;

    @FindBy(className = "blocks-promo")
    WebElement blocksPromo;

    @FindBy(className = "logged-in")
    WebElement greetWelcomeText;

    public HomePage(TestContext context) {
        super(context);
    }
}
