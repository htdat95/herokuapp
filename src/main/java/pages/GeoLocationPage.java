package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GeoLocationPage {
    private final WebDriver driver;
    WebDriverWait wait;
    private By whereAmIButton = By.tagName("button");
    public GeoLocationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void acceptShareLocation(){
        driver.findElement(whereAmIButton).click();
        driver.switchTo().alert().accept();
    }
    public void emulateGeolocation() throws InterruptedException {
        Map<String, Object> params = new HashMap<>();
        params.put("latitude", 10.86586);
        params.put("longitude", 106.7581);
        params.put("accuracy", 1);

        ((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", params);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(whereAmIButton))).click();

        Thread.sleep(3000);
        driver.quit();
    }

}
