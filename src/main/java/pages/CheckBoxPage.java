package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @Step("Step: Verify the url")
    public boolean verifyUrl(){
        String pageUrl = "https://the-internet.herokuapp.com/checkboxes";
        return pageUrl.equals(driver.getCurrentUrl());
    }

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(60));
    }

    @Step("Step: click to check box")
    public boolean selectAllCheckBox(){
        boolean b = true;
        List< WebElement> list = driver.findElements(By.tagName("input"));
        list.forEach((element) -> {
            if(!element.isSelected()){
                element.click();
            }
        });

        for (WebElement webElement : list) {
            if (!webElement.isSelected()) {
                b = false;
                break;
            }
        }
        return b;
    }

    @Step("Step: click to check box")
    public boolean unSelectAllCheckBox(){
        boolean b = true;
        List< WebElement> list = driver.findElements(By.tagName("input"));
        list.forEach((element) -> {
            if(element.isSelected()){
                element.click();
            }
        });

        for (WebElement webElement : list) {
            if (webElement.isSelected()) {
                b = false;
                break;
            }
        }
        return b;
    }
}
