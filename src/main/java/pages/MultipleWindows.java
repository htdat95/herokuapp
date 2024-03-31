package pages;

import log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class MultipleWindows {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By clickLink = By.linkText("Click Here");
    public MultipleWindows(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickHereClick(){
        int i;
        i = driver.getWindowHandles().size();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(clickLink))).click();
        wait.until(numberOfWindowsToBe(i + 1));
        Log.info(String.format("opened %s window",i + 1));
    }
//    public void switchToWindowIndex(int index){
//        int i =0;
//        System.out.println("handle: " + driver.getWindowHandle());
////        Set <String> handles = driver.getWindowHandles();
////        System.out.println("handles: " + handles);
//
//        for (String s:driver.getWindowHandles()) {
//            if(i == index){
//                System.out.println("handles: " + s);
//                driver.switchTo().window(s);
//                break;
//            }else i++;
//        }
//    }

    public void switchToWindowIndex(int index){
        System.out.println("handle: " + driver.getWindowHandle());
        Set <String> handles = driver.getWindowHandles();
        System.out.println("handles: " + handles);
        List <String> list = new ArrayList<>(handles);
        driver.switchTo().window(list.get(index));
    }
}
