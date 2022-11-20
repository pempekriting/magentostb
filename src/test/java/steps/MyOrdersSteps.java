package steps;

import context.TestContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pagesfactory.PagesFactoryManager;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutAction;
import pagesfactory.myorders.MyOrdersPageAction;
import pagesfactory.myorders.MyOrdersPageValidation;

public class MyOrdersSteps {

    final MyOrdersPageAction action;
    final MyOrdersPageValidation validation;
    final ShippingCheckoutAction checkoutAction;

    public MyOrdersSteps(TestContext context) {
        action = PagesFactoryManager.getMyOrdersPageAction(context);
        validation = PagesFactoryManager.getMyOrdersPageValidation(context);
        checkoutAction = PagesFactoryManager.getShippingCheckoutAction(context);
    }

    @Then("the order is successfully submitted")
    public void theOrderIsSuccessfullySubmitted() {
        action.populatedMyOrdersData();
        Assert.assertTrue(validation.validateItemsOrdered(checkoutAction.getDataShippingOrders(), action.getItemsOrdered()), "Data is different! data in shipping: " + checkoutAction.getDataShippingOrders() + " data in cart: " + action.getItemsOrdered());
        Assert.assertTrue(validation.validateShippingAndHandling(checkoutAction.getShippingPrice(), action.getShippingAndHandlingCost()), "Data is different! data in shipping: " + checkoutAction.getShippingPrice() + " data in cart: " + action.getShippingAndHandlingCost());
        Assert.assertTrue(validation.validateSubTotal(checkoutAction.getSubTotalPriceItems(), action.getSubTotalCost()), "Data is different! data in shipping: " + checkoutAction.getSubTotalPriceItems() + " data in cart: " + action.getSubTotalCost());
    }
}
