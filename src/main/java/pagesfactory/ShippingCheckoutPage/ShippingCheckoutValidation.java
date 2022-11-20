package pagesfactory.ShippingCheckoutPage;

import context.TestContext;

import java.util.HashMap;

public class ShippingCheckoutValidation extends ShippingCheckoutPage {
    public ShippingCheckoutValidation(TestContext context) {
        super(context);
    }

    public boolean compareDataOrders(HashMap<String, String> dataOrder1, HashMap<String, String> dataOrder2) {
        return dataOrder1.equals(dataOrder2);
    }
}
