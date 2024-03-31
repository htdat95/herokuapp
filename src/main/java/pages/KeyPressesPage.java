package pages;

import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {
    private final WebDriver driver;
    private final By outputText = By.xpath("//p[@id='result']");
    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean sendCtr(){
        String expectOutput = "You entered: CONTROL";
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.CONTROL).perform();
        String actualOutput = driver.findElement(outputText).getText();
        Log.info("Actual output: " + actualOutput);
        return expectOutput.equals(actualOutput);
    }
}
