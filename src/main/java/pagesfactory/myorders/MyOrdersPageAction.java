package pagesfactory.myorders;

import context.TestContext;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class MyOrdersPageAction extends MyOrdersPage {

    @Getter
    static HashMap<String, String> itemsOrdered = new HashMap<>();
    @Getter
    static double subTotalCost;
    @Getter
    static double shippingAndHandlingCost;

    public MyOrdersPageAction(TestContext context) {
        super(context);
    }

    public void populatedMyOrdersData() {
        fluentWait().until(ExpectedConditions.visibilityOf(shippingAndHandlingPrice));
        for (int i = 0; i < listProductName.size(); i++) {
            itemsOrdered.put(listProductName.get(i).getText().trim(), listSubTotalProductPrice.get(i).getText().trim());
        }
        subTotalCost = Double.parseDouble(subTotalItems.getText().trim().replace("$",""));
        shippingAndHandlingCost = Double.parseDouble(shippingAndHandlingPrice.getText().trim().replace("$",""));
    }
}
