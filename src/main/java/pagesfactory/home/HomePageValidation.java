package pagesfactory.home;

import context.TestContext;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageValidation extends HomePage{
    public HomePageValidation(TestContext context) {
        super(context);
    }

    public boolean isOnPage() {
        return blocksPromo.isDisplayed();
    }

    public boolean isLoggedIn() {
        fluentWait().until(ExpectedConditions.visibilityOf(greetWelcomeText));
        return greetWelcomeText.isDisplayed();
    }
}
