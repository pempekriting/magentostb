package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pagesfactory.PagesFactoryManager;
import pagesfactory.home.HomePageValidation;
import pagesfactory.login.LoginPageAction;

public class LoginSteps {

    final LoginPageAction action;
    final HomePageValidation validation;

    public LoginSteps(TestContext context) {
        action = PagesFactoryManager.getLoginPageAction(context);
        validation = PagesFactoryManager.getHomePageValidation(context);
    }

    @And("User login with valid registered customers")
    public void userLoginWithValidRegisteredCustomers() {
        action.fillLoginForm()
                .andLogin();
    }

    @Then("User successfully logged in to Luma")
    public void userSuccessfullyLoggedInToLuma() {
        Assert.assertTrue(validation.isLoggedIn());
    }
}
