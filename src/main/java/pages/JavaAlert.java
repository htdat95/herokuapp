package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaAlert {
    private final WebDriver driver;
    private WebDriverWait wait;
    By jsAlertBtn = By.xpath("//button[normalize-space()='Click for JS Alert']");
    By jsConfirmBtn = By.xpath("//button[normalize-space()='Click for JS Confirm']");
    By jsPromptBtn = By.xpath("//button[normalize-space()='Click for JS Prompt']");
    By notificationText = RelativeLocator.with(By.tagName("p")).below(By.xpath("//h4[normalize-space()='Result:']"));
    public JavaAlert(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    @Step("Step: Verify the url")
    public boolean verifyUrl(){
        String pageUrl = "https://the-internet.herokuapp.com/javascript_alerts";
        return pageUrl.equals(driver.getCurrentUrl());
    }
    public boolean clickOkOnJSAlert(){
        String expectAlertText ="I am a JS Alert";
        wait.until(ExpectedConditions.elementToBeClickable(jsAlertBtn)).click();
        if(driver.switchTo().alert().getText().equals(expectAlertText)){
            driver.switchTo().alert().accept();
            return true;
        }
        return false;
    }

    public boolean clickOkOnJSConfirm(){
        String expectAlertText ="I am a JS Confirm";
        wait.until(ExpectedConditions.elementToBeClickable(jsConfirmBtn)).click();
        if(driver.switchTo().alert().getText().equals(expectAlertText)){
            driver.switchTo().alert().accept();
            return true;
        }
        return false;
    }
    public boolean clickCancelOnJSConfirm(){
        String expectAlertText ="I am a JS Confirm";
        wait.until(ExpectedConditions.elementToBeClickable(jsConfirmBtn)).click();
        if(driver.switchTo().alert().getText().equals(expectAlertText)){
            driver.switchTo().alert().dismiss();
            return true;
        }
        return false;
    }

    public boolean sendKeyToJSPrompt(String key){
        String expectAlertText ="I am a JS prompt";
        wait.until(ExpectedConditions.elementToBeClickable(jsPromptBtn)).click();
        if(driver.switchTo().alert().getText().equals(expectAlertText)){
            driver.switchTo().alert().sendKeys(key);
            driver.switchTo().alert().accept();
            return true;
        }
        System.out.println(driver.switchTo().alert().getText());
        return false;
    }
    public boolean checkNotification(String notification){
        return notification.equals(driver.findElement(notificationText).getText());
    }

}
