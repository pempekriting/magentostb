package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import pagesfactory.PagesFactoryManager;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutAction;

public class ShippingCheckoutSteps {

    final ShippingCheckoutAction action;

    public ShippingCheckoutSteps(TestContext context) {
        action = PagesFactoryManager.getShippingCheckoutAction(context);
    }

    @And("User fill the shipping address with valid data")
    public void userFillTheShippingAddressWithValidData() {
        action.inputStreetAddress()
                .inputCity()
                .selectStateProvince()
                .inputPostCode()
                .inputPhoneNumber()
                .selectShippingMethods()
                .clickNextButton()
                .clickPlaceOrderButton()
                .clickOrderNumberLink();
    }
}
