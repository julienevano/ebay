package Pages;

import Base.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage {

    Actions actions = new Actions();

    @FindBy(id = "isCartBtn_btn")
    WebElement addToCart;

    @FindBy(id = "atcRedesignId_btn")
    WebElement addToCartSecond;

    @FindBy(id = "msku-sel-1")
    WebElement itemDetails;

    @FindBy(xpath="//button[contains(text(),'No thanks')]")
    WebElement noThanksButton;

    @FindBy(xpath = "//span[contains(text(),'Go to cart')]")
    WebElement goToCartButton;

    @FindBy(id = "sbin-gxo-btn")
    WebElement guestCheckout;

    public void clickAddToCart(){
        actions.clickElement(addToCart);
    }

    public void clickAddToCartAgain(){
        actions.clickElement(addToCartSecond);
    }

    public void guestCheckoutClick(){
        actions.clickElement(guestCheckout);
    }
    public void selectFirstItemDetail(){
        actions.selectFirstitemDropDown(itemDetails);
    }

    public void clickIgnoreButton(){
        actions.clickElement(noThanksButton);
    }

    public void clickGoToCart(){
        actions.clickElement(goToCartButton);
    }
}
