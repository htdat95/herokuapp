package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HorizontalSliderPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By slider = By.tagName("input");
    By resultTxt = By.tagName("span");
    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/horizontal_slider";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void slide(int x, int y){
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(slider))).click();
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(slider), x,y).perform();
//        actions.moveByOffset(x,y)
//                .click();
    }
    public void clickSlide(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(slider))).click();
    }
    public void leftSlide(int times){
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }
    }
    public void rightSlide(int times){
        if (times < 1) return;
        Actions actions = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }

    }
    public boolean verifyValue(double expectedValue){
        double actualValue = Double.parseDouble(driver.findElement(resultTxt).getText());
        System.out.println("aaa: "+actualValue);
        return expectedValue == actualValue;
    }
}
