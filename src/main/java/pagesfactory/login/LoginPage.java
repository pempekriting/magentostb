package pagesfactory.login;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesfactory.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement inpEmail;

    @FindBy(id = "pass")
    WebElement inpPassword;

    @FindBy(id = "send2")
    WebElement btnSignIn;

    public LoginPage(TestContext context) {
        super(context);
    }
}
