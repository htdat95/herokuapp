package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagePage {
    private final WebDriver driver;

    public BrokenImagePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Step: Verify the url")
    public boolean verifyUrl(){
        String pageUrl = "https://the-internet.herokuapp.com/broken_images";
        return pageUrl.equals(driver.getCurrentUrl());
    }

    public void checkImageBroken(){
        int brokenImage =0;
        List< WebElement> lists = driver.findElements(By.tagName("img"));
        for (WebElement list:lists) {
            if(list.getAttribute("naturalWidth").equals("0")){
                System.out.println(list.getAttribute("outerHTML")+" is broken");
                brokenImage ++;
            }
        }
        System.out.println(String.format("There is %s out of %s image that broken",brokenImage,lists.size()));
    }
}
