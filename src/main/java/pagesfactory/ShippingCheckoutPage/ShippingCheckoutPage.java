package pagesfactory.ShippingCheckoutPage;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagesfactory.BasePage;

import java.util.List;

public class ShippingCheckoutPage extends BasePage {

    @FindBy(xpath = "//div[contains(@name,'street.0')]//input")
    WebElement inpStreetAddress;

    @FindBy(xpath = "//div[contains(@name,'city')]//input")
    WebElement inpCity;

    @FindBy(xpath = "//div[contains(@name,'region_id')]//select")
    WebElement slcStateProvince;

    @FindBy(xpath = "//div[contains(@name,'postcode')]//input")
    WebElement inpPostCode;

    @FindBy(xpath = "//div[contains(@name,'country_id')]//select")
    WebElement slcCountry;

    @FindBy(xpath = "//div[contains(@name,'telephone')]//input")
    WebElement inpTelephone;

    String xPathRdbShippingMethods = "//tr[contains(@data-bind,'Method')]";

    @FindBy(xpath = "//button[@data-role='opc-continue']")
    WebElement btnNext;

    @FindBy(xpath = "//button[contains(@data-bind,'Place Order')]")
    WebElement btnPlaceOrder;

    @FindBy(className = "order-number")
    WebElement orderNumberLink;

    @FindBy(className = "product-item-name")
    List<WebElement> listProductName;

    @FindBy(css = ".cart-price>.price")
    List<WebElement> listProductPrice;

    public ShippingCheckoutPage(TestContext context) {
        super(context);
    }
}
