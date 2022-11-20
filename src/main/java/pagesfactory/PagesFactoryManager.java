package pagesfactory;

import context.TestContext;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutAction;
import pagesfactory.ShippingCheckoutPage.ShippingCheckoutValidation;
import pagesfactory.goodsdetail.GoodsDetailAction;
import pagesfactory.home.HomePageAction;
import pagesfactory.home.HomePageValidation;
import pagesfactory.login.LoginPageAction;
import pagesfactory.myorders.MyOrdersPageAction;
import pagesfactory.myorders.MyOrdersPageValidation;

public class PagesFactoryManager {
    static LoginPageAction loginPageAction;
    static HomePageAction homePageAction;
    static HomePageValidation homePageValidation;
    static GoodsDetailAction goodsDetailAction;
    static ShippingCheckoutAction shippingCheckoutAction;
    static ShippingCheckoutValidation shippingCheckoutValidation;
    static MyOrdersPageAction myOrdersPageAction;
    static MyOrdersPageValidation myOrdersPageValidation;

    public static LoginPageAction getLoginPageAction(TestContext context) {
        return loginPageAction == null ? new LoginPageAction(context) : loginPageAction;
    }

    public static HomePageAction getHomePageAction(TestContext context) {
        return homePageAction == null ? new HomePageAction(context) : homePageAction;
    }

    public static HomePageValidation getHomePageValidation(TestContext context) {
        return homePageValidation == null ? new HomePageValidation(context) : homePageValidation;
    }

    public static GoodsDetailAction getGoodsDetailAction(TestContext context) {
        return goodsDetailAction == null ? new GoodsDetailAction(context) : goodsDetailAction;
    }

    public static ShippingCheckoutAction getShippingCheckoutAction(TestContext context) {
        return shippingCheckoutAction == null ? new ShippingCheckoutAction(context) : shippingCheckoutAction;
    }

    public static ShippingCheckoutValidation getShippingCheckoutValidation(TestContext context) {
        return shippingCheckoutValidation == null ? new ShippingCheckoutValidation(context) : shippingCheckoutValidation;
    }

    public static MyOrdersPageAction getMyOrdersPageAction(TestContext context) {
        return myOrdersPageAction == null ? new MyOrdersPageAction(context) : myOrdersPageAction;
    }

    public static MyOrdersPageValidation getMyOrdersPageValidation(TestContext context) {
        return myOrdersPageValidation == null ? new MyOrdersPageValidation(context) : myOrdersPageValidation;
    }
}
