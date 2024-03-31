package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFramePage {
    private final WebDriver driver;
    WebDriverWait wait;
    By middleFrameText = By.xpath("//html/body/div");
    By otherFrameText = By.xpath("//html/body");
    public NestedFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }
    public boolean verifyFrameText(String frame,String expectedText){
        String actualText;
        if (frame.equals("frame-middle")){
            actualText = driver.findElement(middleFrameText).getText();
        }else {
            actualText = driver.findElement(otherFrameText).getText();
        }
        return actualText.contains(expectedText);
    }
}
