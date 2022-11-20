package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesfactory.PagesFactoryManager;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutAction;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutValidation;
import pagesfactory.goodsdetail.GoodsDetailAction;
import pagesfactory.home.HomePageAction;
import pagesfactory.home.HomePageValidation;

public class HomeSteps {
    final HomePageAction action;
    final HomePageValidation validation;
    final GoodsDetailAction actionGoodsDetail;
    final ShippingCheckoutAction actionShippingCheckout;
    final ShippingCheckoutValidation validationShippingCheckout;


    public HomeSteps(TestContext context) {
        action = PagesFactoryManager.getHomePageAction(context);
        validation = PagesFactoryManager.getHomePageValidation(context);
        validationShippingCheckout = PagesFactoryManager.getShippingCheckoutValidation(context);
        actionGoodsDetail = PagesFactoryManager.getGoodsDetailAction(context);
        actionShippingCheckout = PagesFactoryManager.getShippingCheckoutAction(context);
    }
    
    @Given("User is at Home Page")
    public void userIsAtHomePage() {
        Assert.assertTrue(validation.isOnPage());
    }

    @Given("User is at {string} {string} {string} menu")
    public void userIsAtTopsJacketMenu(String mainMenu, String subMenu, String secondSubMenu) {
        action.hoverNavigationMenu(mainMenu)
                .hoverNavigationMenu(subMenu, "-men")
                .clickNavigationMenu(secondSubMenu, "-men");
        action.waitABit(2);
    }

    @When("User go to the sign in page")
    public void userGoToTheSignInPage() {
        action.goToLoginPage();
    }

    @And("User navigate to {string} {string} {string} menu")
    public void userNavigateToMenu(String mainMenu, String subMenu, String secondSubMenu) {
        action.hoverNavigationMenu(mainMenu)
                .hoverNavigationMenu(subMenu, "-men")
                .clickNavigationMenu(secondSubMenu, "-men");
        action.waitABit(2);
    }

    @And("User navigate to the cart page")
    public void userNavigateToTheCartPage() {
        actionGoodsDetail.goToCartPage();
        actionShippingCheckout.populatedDataOrders();
        actionShippingCheckout.calculateSubTotalItems();
        Assert.assertTrue(validationShippingCheckout.compareDataOrders(actionShippingCheckout.getDataShippingOrders(), actionGoodsDetail.getDetailOrders()),
                "Data is different! data in shipping: " + actionShippingCheckout.getDataShippingOrders() + " data in cart: " + actionGoodsDetail.getDetailOrders());
    }
}
