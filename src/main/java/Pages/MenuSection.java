package Pages;

import driver_factory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class MenuSection {
    public HashMap<String, WebElement> menuHashMap = new HashMap<String, WebElement>();

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a") //  //div[@id='block_top_menu']/ul/li/a
    WebElement menuWomen;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]/a")
    WebElement menuWomenTops;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]/ul/li[1]/a")
    WebElement menuWomenTopsTshirt;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[1]/ul/li[2]")
    WebElement menuWomenTopsBlouses;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/a/following-sibling::ul/li[2]/a")
    WebElement menuWomenDresses;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
    WebElement menuDresses;

    public MenuSection(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        setMenu();
    }

    public void setMenu(){
        menuHashMap.put("menuWomen",menuWomen); // FirstMenu
        menuHashMap.put("menuWomenTops",menuWomenTops); // FirstMenu->submenu
        menuHashMap.put("menuWomenTopsTshirt",menuWomenTopsTshirt); // FirstMenu->submenu->submenu
        menuHashMap.put("menuWomenTopsBlouses",menuWomenTopsBlouses); // // FirstMenu->submenu->submenu
        menuHashMap.put("menuWomenDresses",menuWomenDresses); // FirstMenu->submenu
        menuHashMap.put("menuDresses",menuDresses);
    }

    public HashMap<String, WebElement> getPageMenu(){
        return menuHashMap;
    }
}
