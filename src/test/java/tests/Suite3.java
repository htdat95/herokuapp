package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Suite3 {
    WebDriver driver;
    By canvasLocator = By.id("burger_canvas");
    @BeforeClass
    public void initBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @BeforeMethod
    public void openUrl(){
        driver.get("https://kitchen.applitools.com/ingredients/canvas");
    }

    @Test
    void canVasTest() throws InterruptedException {
        WebElement canvas = driver.findElement(canvasLocator);
        Dimension canvas_center = canvas.getSize();
        int canvas_center_y = canvas_center.getHeight() / 2;
        int canvas_center_x = canvas_center.getWidth() / 2;
        int button_x = canvas_center_x /3 * 3 + canvas_center_x;
        int button_y = canvas_center_y /3 * 1;
        System.out.println("center x: "+ canvas_center_x);
        System.out.println("center y: "+ canvas_center_y);
        System.out.println("button x: "+ button_x);
        System.out.println("button y: "+ button_y);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas,button_x,button_y)
                .click()
                .perform();
        Thread.sleep(5000);
    }
}
