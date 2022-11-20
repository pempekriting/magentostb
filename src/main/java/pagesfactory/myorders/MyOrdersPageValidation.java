package pagesfactory.myorders;

import context.TestContext;

import java.util.HashMap;

public class MyOrdersPageValidation extends MyOrdersPage{
    public MyOrdersPageValidation(TestContext context) {
        super(context);
    }

    public boolean validateItemsOrdered(HashMap<String, String> data1, HashMap<String, String> data2) {
        return data1.equals(data2);
    }

    public boolean validateSubTotal(double subTotalShipping, double subTotalMyOrders) {
        return subTotalShipping == subTotalMyOrders;
    }

    public boolean validateShippingAndHandling(double totalShipping, double totalShippingMyOrders) {
        return totalShipping == totalShippingMyOrders;
    }
}
