package pagesfactory.myorders;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesfactory.BasePage;

import java.util.List;

public class MyOrdersPage extends BasePage {

    @FindBy(xpath = "//strong[contains(@class,'product name')]")
    List<WebElement> listProductName;

    @FindBy(xpath = "//td[@class='col subtotal']//span[@class='price']")
    List<WebElement> listSubTotalProductPrice;

    @FindBy(xpath = "//tr[@class='subtotal']//span")
    WebElement subTotalItems;

    @FindBy(xpath = "//tr[@class='shipping']//span")
    WebElement shippingAndHandlingPrice;

    public MyOrdersPage(TestContext context) {
        super(context);
    }
}
