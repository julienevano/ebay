package tests.CheckoutTests;

import Base.Actions;
import Base.BaseDriver;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ItemPage;
import Pages.SearchPage;
import commonUtils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


public class Tests extends Actions {

    BaseDriver base = new BaseDriver();
    ConfigReader configReader = new ConfigReader();
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        String url = configReader.getPropertyValue("url");
        getUrl(browser, url);
    }

    @DataProvider(name = "SearchCatalogue")
    public static Object[][] searchData() {
        return new Object[][]{{"Rice Cooker", "Stroller"}};

    }


    @Test(dataProvider = "SearchCatalogue")
    public void testSuccessfulLogin(String itemOne, String itemTwo) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ItemPage itemPage = PageFactory.initElements(driver, ItemPage.class);
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        homePage.setSearchBox(itemOne);
        homePage.clickSearchButton();

        searchPage.selectFirstItem();

        itemPage.clickAddToCart();
        itemPage.clickIgnoreButton();


        homePage.setSearchBox(itemTwo);
        homePage.clickSearchButton();

        searchPage.selectFirstItem();

        itemPage.selectFirstItemDetail();
        itemPage.clickAddToCartAgain();
        itemPage.clickGoToCart();

        boolean flag = checkoutPage.validateItems();
        Assert.assertTrue(flag);

        checkoutPage.clickRemoveButton();
        checkoutPage.validateItem();
        checkoutPage.waitSeconds();
        checkoutPage.clickRemoveButton();

    }



    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

}
