package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;
import java.util.Set;

public class JSErrorPage {
    private final WebDriver driver;

    public JSErrorPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/javascript_error";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
//    public void checkJSError(){
//        Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
//        for (String s : logtyp) {
//            System.out.println(logtyp);
//        }
//        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//        List<LogEntry> lg = logEntries.filter(Level.ALL);
//        for(LogEntry logEntry : lg) {
//            System.out.println(logEntry);
//        }
//    }
}
