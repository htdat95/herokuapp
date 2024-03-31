package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryUIMenuPage {
    private final WebDriver driver;

    WebDriverWait wait;
    By subDownloadsLink = By.linkText("Downloads");
    By subBackToJQueryUILink = By.linkText("Back to JQuery UI");
    By enabledLink = By.linkText("Enabled");
    By subPDFLink  = By.linkText("PDF");
    By subCSVLink  = By.linkText("CSV");
    By subExcelLink  = By.linkText("Excel");
    public JQueryUIMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/jqueryui/menu";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void moveToFirstSubMenu(String option){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(enabledLink)).perform();
        if(option.equals("Downloads")){
            wait.until(ExpectedConditions.elementToBeClickable(subDownloadsLink));
            actions.moveToElement(driver.findElement(subDownloadsLink))
                    .perform();
        }else{
            wait.until(ExpectedConditions.elementToBeClickable(subBackToJQueryUILink));
            actions.moveToElement(driver.findElement(subBackToJQueryUILink))
                    .perform();
        }
    }
    public void moveToSecondSubMenu(String option){
        moveToFirstSubMenu("Downloads");
        Actions actions = new Actions(driver);
        switch (option) {
            case "PDF" -> {
                wait.until(ExpectedConditions.elementToBeClickable(subPDFLink));
                actions.moveToElement(driver.findElement(subPDFLink))
                        .click()
                        .build()
                        .perform();
                }
            case "Excel" -> {
                wait.until(ExpectedConditions.elementToBeClickable(subExcelLink));
                actions.moveToElement(driver.findElement(subExcelLink))
                        .click()
                        .build()
                        .perform();
            }
            case "CSV" -> {
                wait.until(ExpectedConditions.elementToBeClickable(subCSVLink));
                actions.moveToElement(driver.findElement(subCSVLink))
                        .click()
                        .build()
                        .perform();
            }
        }
    }
}
