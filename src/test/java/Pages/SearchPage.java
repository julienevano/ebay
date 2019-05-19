package Pages;

import Base.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

    Actions actions = new Actions();

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[1]//a")
    WebElement selectItems;

    public void selectFirstItem(){
        actions.selectFirstitem(selectItems);
    }
}
