package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDownPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(60));
    }

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/dropdown";
        return expectedUrl.equals(driver.getCurrentUrl());
    }

    public void selectOption(String key){
        Select sel = new Select(driver.findElement(By.tagName("select")));
        sel.selectByVisibleText(key);
    }
}
