package pagesfactory.login;

import context.TestContext;

public class LoginPageAction extends LoginPage {
    public LoginPageAction(TestContext context) {
        super(context);
    }

    public LoginPageAction fillLoginForm() {
        inpEmail.sendKeys("kgs.azzam3@mailinator.com");
        inpPassword.sendKeys("Testing123");
        return this;
    }

    public void andLogin() {
        btnSignIn.click();
    }
}
