package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class ExitIntentPage {
    private final WebDriver driver;
    WebDriverWait wait;

    By closeBtn = By.xpath("//p[normalize-space()='Close']");

    public ExitIntentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/exit_intent";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void moveOutMouse() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(600,0);
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void moveOutMouse2()  {
        Actions actions = new Actions(driver);
        actions.moveByOffset(600,-1).build().perform();
    }
}
