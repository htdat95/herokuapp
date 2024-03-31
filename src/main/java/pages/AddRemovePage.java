package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemovePage {
    private final WebDriver driver;

    private final By addElementBtn = By.xpath("(//button[normalize-space()='Add Element'])[1]");
    private final By elementBtn = By.xpath("//*[@class='added-manually']");
    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/add_remove_elements/";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    @Step ("Adding elements {0}......")
    public void addElement(int number) throws InterruptedException {
        if (number <=0) {
            System.out.println("Number invalid");
            return ;
        }
        for(int i = 0; i< number; i ++){
            driver.findElement(addElementBtn).click();
            Thread.sleep(1000);
        }
    }
    @Step ("Checking elements existed {0} ......")
    public boolean verifyElementsExisted(int number){
        if (number <=0) {
            System.out.println("Number invalid");
            return false;
        }
        List< WebElement> list = driver.findElements(elementBtn);
        return list.size() == number;
    }

    @Step ("Remove {0} element......")
    public void deleteElement(int number){
        if (number <0) {
            System.out.println("Number invalid");
            return;
        }
        int i = 0;
        List< WebElement> list = driver.findElements(elementBtn);
        if(list.size()<number){
            System.out.println("Number remove is greater than number of elements existed");
            return;
        }
        while (i < number){
            driver.findElement(elementBtn).click();
            i++;
        }
    }
}
