package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By chooseFileBtn = By.xpath("//input[@type='file']");
    By uploadBtn = By.xpath("//input[@class='button']");

    public UploadPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/upload";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void upload(){
        String location = "C:\\Users\\PC\\Downloads\\TextDoc.txt";
        driver.findElement(chooseFileBtn).sendKeys(location);
        driver.findElement(uploadBtn).click();
    }
}
