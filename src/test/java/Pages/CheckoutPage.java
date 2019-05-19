package Pages;

import Base.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Actions{

    Actions actions = new Actions();
    WebDriver driver;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    WebElement removeButton;

    public void clickRemoveButton(){
        actions.clickElement(removeButton);
    }


    public boolean validateItems(){
        driver = actions.driver;
       int size = driver.findElements(By.xpath("//span[contains(text(),'Items (2)')]")).size();
       if(size>0){
           return true;
       }
       return false;
    }


    public boolean validateItem(){
        driver = actions.driver;
        int size = driver.findElements(By.xpath("//span[contains(text(),'Items (1)')]")).size();
        if(size>0){
            return true;
        }
        return false;
    }
}
