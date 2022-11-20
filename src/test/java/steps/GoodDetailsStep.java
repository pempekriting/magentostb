package steps;

import context.TestContext;

import io.cucumber.java.en.When;
import pagesfactory.PagesFactoryManager;
import pagesfactory.goodsdetail.GoodsDetailAction;
import pagesfactory.home.HomePageAction;

public class GoodDetailsStep {

    final GoodsDetailAction action;

    public GoodDetailsStep(TestContext context) {
        action = PagesFactoryManager.getGoodsDetailAction(context);
    }

    @When("User buy {int} items")
    public void userBuyNItems(int totalItems) {
        action.addToCartItem(totalItems);
    }
}
