package pagesfactory.goodsdetail;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesfactory.BasePage;

import java.util.List;

public class GoodsDetailPage extends BasePage {

    @FindBy(css = ".item.product")
    List<WebElement> listProducts;

    @FindBy(xpath = "//a[contains(@class,'showcart')]")
    WebElement cartIcon;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement btnProceedToCheckout;

    String xPathItemPrice = ".//span[@class='price']";

    String xPathItemName = ".//a[@class='product-item-link']";

    String xPathListSizesItem = ".//div[@class='swatch-option text']";

    String xPathListColorItem = ".//div[@class='swatch-option color']";

    String xPathAddToCartButton = ".//*[contains(@class,'tocart')]";

    String xPathAlert = "//div[@role='alert']//div[contains(@data-bind,'html')]";

    public GoodsDetailPage(TestContext context) {
        super(context);
    }
}
