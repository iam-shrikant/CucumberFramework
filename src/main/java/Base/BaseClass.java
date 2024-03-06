package Base;
import Utilities.Util;
import driver_factory.DriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static  Properties prop = new Properties();

    //public static Utilities util;
    public final int WAIT_TIME_10_SECOND = 10;
    public final int WAIT_TIME_20_SECOND = 20;

    public synchronized void loadProperties(){
        //Log.info("BaseClass - loadProperties() initiated");
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties"));
        } catch (IOException e) {
            //Log.error("BaseClass - loadProperties() Got Exception -",e);
        }
    }

    public void setupDriver(String browser){
        //Log.info("BaseClass - setupDriver() initiated");
        //loadProperties();
        DriverManager.setDriver(browser);
    }

    public void launchWebsite(){
        // util = new Utilities();
        //Log.info("BaseClass - launchWebsite() initiated");
        Util.implicitilyWait(WAIT_TIME_10_SECOND);
        Util.pageLoadTimeout(WAIT_TIME_20_SECOND);
        Util.launchWebsite(prop.getProperty("url"));
        Util.maximizeScreen();
    }

    public void doEndTest(){
        Util.exitTest();
        DriverManager.unload();
    }
}