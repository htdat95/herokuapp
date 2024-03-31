package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;
//    @BeforeClass
//    public void initBrowser(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

//    @AfterClass
//    public void teardown(){
//        driver.quit();
//    }

//    public static WebDriver getDriver() {
//        return driver;
//    }
//    @BeforeMethod
//    public void openUrl(){
//        driver.get("https://the-internet.herokuapp.com/");
//    }

}

