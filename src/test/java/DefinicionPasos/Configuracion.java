package DefinicionPasos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuracion {

    static WebDriver driver;
    static String pathDriver = "/opt/homebrew/bin/chromedriver";
    static String driverType = "webdriver.chrome.driver";

    public static WebDriver configure() throws Exception {

        if (driver != null){
            return driver;
        }
        System.setProperty(driverType, pathDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }
}
