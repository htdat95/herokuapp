package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By removeBtn = By.xpath("//button[normalize-space()='Remove']");
    By enableBtn = By.xpath("//button[normalize-space()='Enable']");
    By disableBtn = By.xpath("//button[normalize-space()='Disable']");
    By checkBox = By.xpath("//input[@type='checkbox']");
    By addBtn = By.xpath("//button[normalize-space()='Add']");
    By checkboxText = By.xpath("//*[@id='checkbox-example']/p");
    By inputBtn = By.xpath("(//button)[2]");
    By inputText = By.xpath("//input[@type='text']");
    By resultText = By.xpath("//*[@id='input-example']/p");
    final int TIMEOUT = 120;
    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/dynamic_controls";
        return expectedUrl.equals(driver.getCurrentUrl());
    }

    public boolean removeElement() throws InterruptedException {
        String expectedText = "It's gone!";
        String actualText;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
            driver.findElement(removeBtn).click();
        }catch (NoSuchElementException e){
            return false;
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
        actualText = driver.findElement(checkboxText).getText();
        Thread.sleep(3000);
        return actualText.equals(expectedText);
    }


    public boolean tickCheckbox() throws InterruptedException {
        String expectedText = "It's back!";
        String actualText;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(addBtn));
            driver.findElement(addBtn).click();
        }catch (NoSuchElementException e){
            return false;
        }
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        actualText = driver.findElement(checkboxText).getText();
        Thread.sleep(3000);

        return actualText.equals(expectedText);
    }

    public boolean tickEnable(String s) throws InterruptedException {
        String expectedText = "It's enabled!";
        String actualText;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(inputBtn)).click();
        }catch (NoSuchElementException e){
            return false;
        }
//        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(inputText)).sendKeys(s);
        actualText = driver.findElement(resultText).getText();
        Thread.sleep(3000);

        return actualText.equals(expectedText);
    }

    public boolean tickDisable() throws InterruptedException {
        String expectedText = "It's enabled!";
        String actualText;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(addBtn));
            driver.findElement(addBtn).click();
        }catch (NoSuchElementException e){
            return false;
        }
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        actualText = driver.findElement(checkboxText).getText();
        Thread.sleep(3000);

        return actualText.equals(expectedText);
    }
}
