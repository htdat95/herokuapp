package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicallyLoadedPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By exampleBtn_1 = By.partialLinkText("Example 1");
    By exampleBtn_2 = By.partialLinkText("Example 2");
    By finishText = By.xpath("//*[@id='finish']/h4");
    By startBtn = By.xpath("//button[.='Start']");
    public DynamicallyLoadedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/dynamic_loading";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void clickLink(int index){
        if(index == 1){
            driver.findElement(exampleBtn_1).click();
        } else if (index == 2) {
            driver.findElement(exampleBtn_2).click();
        }
    }

    public boolean isElementDisplayed(){
        String s = driver.findElement(finishText).getText();
        System.out.println(s);
        return driver.findElement(finishText).isDisplayed();
    }
    public boolean clickStart(){
        String expectedText = "Hello World!";
        String actualText;
        driver.findElement(startBtn).click();
        actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(finishText)).getText();
        System.out.println("Actual text: " + actualText);
        return expectedText.equals(actualText);
    }

}
