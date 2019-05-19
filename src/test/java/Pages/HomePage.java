package Pages;

import Base.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage {

    Actions actions = new Actions();

    @FindBy(id = "gh-ac")
    WebElement searchBox;

    @FindBy(id = "gh-btn")
    WebElement searchButton;

    public void setSearchBox(String inputVal) {
        actions.sendKeysInElement(searchBox, inputVal);
        Reporter.log("\n" + inputVal + " is set to the field ", true);
    }

    public void clickSearchButton() {
        actions.clickElement(searchButton);
        Reporter.log("\n searchButton is set to the field ", true);
    }


}
