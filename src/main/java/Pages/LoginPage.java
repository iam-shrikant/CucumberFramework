package Pages;

import Base.BaseClass;
import Utilities.Util;
import driver_factory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass implements Page{

    public static final String expectedPageTitle = "Login - My Shop";

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "SubmitLogin")
    WebElement SubmitLogin;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/ol/li")
    WebElement errorText;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void enterEmailAddress(String emailAddress){
        Util.sendKeys(email,emailAddress);
    }

    public void enterPassword(String password){
        Util.sendKeys(passwd,password);
    }

   /* public AccountPage clickOnSignInbtn(){
        Util.clickOn(SubmitLogin);
        return new AccountPage();
    }*/

    public boolean isErrorDisplayed(){
        return  Util.isElementVisible(errorText,WAIT_TIME_10_SECOND);
    }

    public String readError(){
        return Util.getText(errorText);
    }

    @Override
    public String getPageTitle() {
        return Util.pageTitle();
    }
}
