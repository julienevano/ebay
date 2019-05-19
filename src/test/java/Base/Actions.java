package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Actions extends BaseDriver {

   public WebDriver driver;
   BaseDriver base = new BaseDriver();

    public void getUrl(String browser, String url) {
        driver= base.chooseDriver(browser);
        driver.get(url);
    }

    public void clickElement(WebElement element) {
        waitForElement(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeysInElement(WebElement element, String keys) {
        waitForElement(element);
        element.sendKeys(keys);
    }

    public String getTextFromElement(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    public void selectFirstitem(WebElement element){
        waitForElement(element);
        element.click();
    }

    public void selectFirstitemDropDown(WebElement element){
        waitForElement(element);
        Select select = new Select(element);
        select.selectByIndex(1);
    }

    public void waitForPagetoBeClickable(){
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
    }

    public void waitFewSeconds(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public void waitSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
