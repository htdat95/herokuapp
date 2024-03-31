package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenuPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private By contextMenu = By.xpath("//div[@id='hot-spot']");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    @Step("Step: Verify the url")
    public boolean verifyUrl(){
        String pageUrl = "https://the-internet.herokuapp.com/context_menu";
        return pageUrl.equals(driver.getCurrentUrl());
    }

    @Step("Step: Clicking contextMenu")
    public boolean contextClick(){
        String expectedText = "You selected a context menu";
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextMenu)).perform();
        if(driver.switchTo().alert().getText().equals(expectedText)){
            driver.switchTo().alert().accept();
            return true;
        }else System.out.println(driver.switchTo().alert().getText());

        return false;
    }
}
