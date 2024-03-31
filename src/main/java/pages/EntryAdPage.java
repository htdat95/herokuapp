package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdPage {
    private final WebDriver driver;
    WebDriverWait wait;

    By closeBtn = By.xpath("//p[.='Close']");
    By reEnableBtn = By.linkText("click here");
    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/entry_ad";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void clickClose(){
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }
    public void clickReEnable(){
        wait.until(ExpectedConditions.elementToBeClickable(reEnableBtn)).click();
        driver.navigate().refresh();
    }
}
