package driver_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverManager { //no one should be able to extend this class

    private DriverManager(){
        //not allowing anyone to create object of this class
    }

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            driver.set(new ChromeDriver());
            //Log.info("DriverManager - setDriver() - Chrome driver is setup");
        }else if(browserName.equalsIgnoreCase("Firefox")){
            driver.set(new FirefoxDriver());
            //Log.info("DriverManager - setDriver() - Firefox driver is setup");
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void unload(){
        driver.remove();
        //Log.info("DriverManager - unload() - Driver has been unload");
    }
}
