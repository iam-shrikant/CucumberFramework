package Pages;

import Base.BaseClass;
import Utilities.Util;
import driver_factory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BaseClass implements Page {

    public static final String expectedPageTitle = "My account - My Shop";

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement pageName;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement singOut;
    public MenuSection menuSection;

    public AccountPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        menuSection = new MenuSection();
    }

    @Override
    public String getPageTitle(){
        return Util.pageTitle();
    }

    public LoginPage signOutUser(){
        try {
            Util.clickOn(singOut);
        }catch (NullPointerException e){
            System.out.println("Got null pointer exception");
        }
        return new LoginPage();
    }
}

