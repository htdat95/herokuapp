package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By textLink = By.linkText("TextDoc.txt");
    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }
    public void download(){
        driver.findElement(textLink).click();
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/download";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
}
