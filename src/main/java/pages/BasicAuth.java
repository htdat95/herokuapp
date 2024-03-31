package pages;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

import java.net.URI;
import java.net.URL;
import java.util.function.Predicate;

public class BasicAuth {
    private final WebDriver driver;

    public BasicAuth(WebDriver driver) {
        this.driver = driver;
    }
// Can send user/pass to Basic auth by this: https://admin:admin@the-internet.herokuapp.com/basic_auth

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/basic_auth";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
}
