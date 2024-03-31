package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearElement {
    private final WebDriver driver;
    By linkText = By.xpath("//li/a");
    public DisappearElement(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/disappearing_elements";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void reload_toGet_allElement() throws InterruptedException {
        List<WebElement> list;
        while (true){
            list = driver.findElements(linkText);
            if(list.size()<5) {
                driver.navigate().refresh();
                Thread.sleep(2000);
            } else {
                break;
            }
        }
    }
}
