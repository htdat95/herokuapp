package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoversPage {
    private final WebDriver driver;
    WebDriverWait wait;
    By userHover_1 = By.xpath("(//div[@class='figure'])[1]");
    By userHover_2 = By.xpath("(//div[@class='figure'])[2]");
    By userHover_3 = By.xpath("(//div[@class='figure'])[3]");
    By profile = By.xpath(".//div/a");
    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/hovers";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
    public void clickHoverUser(int index) throws InterruptedException {

        String profileXpath = ".//a[@href='/users/"+index+"']";
        String userXpath = String.format("(//div[@class='figure'])[%d]",index);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(userXpath)))
                .perform();
        actions.click(driver.findElement(By.xpath(profileXpath))).perform();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
