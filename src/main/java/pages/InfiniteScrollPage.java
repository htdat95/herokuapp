package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class InfiniteScrollPage {
    private final WebDriver driver;
    By elementTxt = By.xpath("//div[@class='jscroll-added']");
    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/infinite_scroll";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void scrollToElement(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(elementTxt));
    }
    public void scrollTo() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
    }
    public void scrollTo2() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        Thread.sleep(10000);
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        Actions actions = new Actions(driver);
        actions.scrollFromOrigin(scrollOrigin,0,600)
                .perform();
    }
    public void scrollToElement2(){
        WebElement txt = driver.findElement(By.xpath("(//div[@class='jscroll-added'])[5]"));
        new Actions(driver)
                .scrollToElement(txt)
                .perform();
    }
    public void scrollActionsClass() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        Thread.sleep(4000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .sendKeys(Keys.END)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

    public void scrollRobotClass() throws AWTException, InterruptedException {
        driver.get("https://www.selenium.dev/");
        Thread.sleep(10000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_END);
    }
}
