package pagesfactory.ShippingCheckoutPage;

import context.TestContext;
import io.cucumber.java.eo.Do;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

public class ShippingCheckoutAction extends ShippingCheckoutPage {

    @Getter
    static HashMap<String, String> dataShippingOrders = new HashMap<>();
    @Getter
    static double shippingPrice;
    @Getter
    static double subTotalPriceItems;

    public void populatedDataOrders() {
        for (int i = 0; i < listProductName.size(); i++) {
            dataShippingOrders.put(listProductName.get(i).getText().trim(), listProductPrice.get(i).getText().trim());
        }
        System.out.println(dataShippingOrders);
    }

    public ShippingCheckoutAction inputStreetAddress() {
        fluentWait().until(ExpectedConditions.elementToBeClickable(inpStreetAddress));
        waitABit(2);
        inpStreetAddress.sendKeys(faker.address().streetAddress());
        return this;
    }

    public ShippingCheckoutAction inputCity() {
        inpCity.sendKeys(faker.address().city());
        return this;
    }

    public ShippingCheckoutAction selectStateProvince() {
        Select selectStateProvince = findSelect(slcStateProvince);

        List<WebElement> optionList = selectStateProvince.getOptions();
        optionList.get(randomNumber(optionList.size() - 1, 0)).click();
        return this;
    }

    public ShippingCheckoutAction inputPostCode() {
        inpPostCode.sendKeys(faker.address().zipCode());
        return this;
    }

    public ShippingCheckoutAction selectCountry() {
        Select selectCountry = findSelect(slcCountry);

        selectCountry.selectByVisibleText("Indonesia");
        return this;
    }

    public ShippingCheckoutAction inputPhoneNumber() {
        inpTelephone.sendKeys(faker.phoneNumber().phoneNumber());
        return this;
    }

    public ShippingCheckoutAction selectShippingMethods() {
        List<WebElement> chooseShipping = findElements(xPathRdbShippingMethods);
        WebElement dataToClick = chooseShipping.get(randomNumber(chooseShipping.size() - 1, 0));
        dataToClick.click();
        shippingPrice = Double.parseDouble(dataToClick.findElement(By.xpath("./td[2]")).getText().trim().replace("$", ""));
        waitABit(5);
        return this;
    }

    public ShippingCheckoutAction clickNextButton() {
        btnNext.click();
        return this;
    }

    public ShippingCheckoutAction clickPlaceOrderButton() {
        waitABit(5);
        fluentWait().until(ExpectedConditions.elementToBeClickable(btnPlaceOrder)).click();
        return this;
    }

    public void clickOrderNumberLink() {
        fluentWait().until(ExpectedConditions.elementToBeClickable(orderNumberLink)).click();
    }

    public void calculateSubTotalItems() {
        for (String price : dataShippingOrders.values()) {
            subTotalPriceItems = subTotalPriceItems + Double.parseDouble(price.trim().replace("$", ""));
        }
    }

    public ShippingCheckoutAction(TestContext context) {
        super(context);
    }
}
