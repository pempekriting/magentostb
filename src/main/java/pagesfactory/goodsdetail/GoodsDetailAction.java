package pagesfactory.goodsdetail;

import context.TestContext;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class GoodsDetailAction extends GoodsDetailPage {

    @Getter
    static HashMap<String, String> detailOrders = new HashMap<>();
    public GoodsDetailAction(TestContext context) {
        super(context);
    }

    public void addToCartItem(int totalItems) {
        for (int i = 0; i < totalItems; i++) {
            //define object
            WebElement elementToExecute = listProducts.get(randomNumber(listProducts.size() - 1, 0));

            String itemName = elementToExecute.findElement(By.xpath(xPathItemName)).getText().trim();
            String itemPrice = elementToExecute.findElement(By.xpath(xPathItemPrice)).getText().trim();

            detailOrders.put(itemName,itemPrice);

            //Choose random size
            List<WebElement> listSize = elementToExecute.findElements(By.xpath(xPathListSizesItem));
            listSize.get(randomNumber(listSize.size() - 1, 0)).click();

            //Choose random color
            List<WebElement> listColor = elementToExecute.findElements(By.xpath(xPathListColorItem));
            listColor.get(randomNumber(listColor.size() - 1, 0)).click();

            //Hover object to get the add to cart button
            hoverObject(elementToExecute);

            //Setup scroll event
            WebElement addToCartButton = elementToExecute.findElement(By.xpath(xPathAddToCartButton));
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(addToCartButton);
            getActions().scrollFromOrigin(scrollOrigin, addToCartButton.getRect().x + 30, addToCartButton.getRect().y + 30);
            hoverObject(elementToExecute);

            //Click add to cart button
            addToCartButton.click();

            //Wait until success add to cart
            fluentWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPathAlert), itemName));
        }
    }

    public void goToCartPage() {
        cartIcon.click();
        btnProceedToCheckout.click();
        waitABit(10);
    }
}
