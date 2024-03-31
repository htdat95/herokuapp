package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DragAndDropPage {
    private final WebDriver driver;
    private final By fromElement = By.xpath("//div[@class='column'][1]");
    private final By toElement = By.xpath("//div[@class='column'][2]");

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        return expectedUrl.equals(driver.getCurrentUrl());
    }

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void drapAndDrop(){
        Actions actions = new Actions(driver);
        Actions drapAndDrops = actions.clickAndHold(driver.findElement(fromElement))
                .moveToElement(driver.findElement(toElement))
                .release(driver.findElement(toElement));
        drapAndDrops.build().perform();
    }
}
