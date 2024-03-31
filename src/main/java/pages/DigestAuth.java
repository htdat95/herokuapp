package pages;

import org.openqa.selenium.WebDriver;

public class DigestAuth {
    private final WebDriver driver;

    public DigestAuth(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUrl(){
        String expectedUrl = "https://the-internet.herokuapp.com/digest_auth";
        return expectedUrl.equals(driver.getCurrentUrl());
    }
}
