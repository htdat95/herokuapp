package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Enabled;
import log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;

public class Suite2 extends BaseTest{
    WebDriver driver;
    BasePage basePage;
    DropDownPage dropDownPage;
    DragAndDropPage dragAndDropPage;
    BasicAuth basicAuth;
    DigestAuth digestAuth;
    ContextMenuPage contextMenuPage;
    EntryAdPage entryAdPage;
    ExitIntentPage exitIntentPage;
    DownloadPage downloadPage;
    UploadPage uploadPage;
    HorizontalSliderPage horizontalSliderPage;
    KeyPressesPage keyPressesPage;
    MultipleWindows multipleWindows;
    @BeforeClass
    public void initBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @BeforeMethod
    public void openUrl(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    void dropDownTest(){
        basePage = new BasePage(driver);
        dropDownPage = basePage.clickDropDown();
        Log.info("Click drop down link text successfully");
        Assert.assertTrue(dropDownPage.verifyUrl(),"the url is not matched");
        Log.info("Verify Url successfully");
        dropDownPage.selectOption("Option 2");
    }

    @Test
    void drapAndDropTest() throws InterruptedException {
        basePage = new BasePage(driver);
        dragAndDropPage = basePage.clickDragAndDrop();
        Log.info("Click drapAndDrop link text successfully");
        Assert.assertTrue(dragAndDropPage.verifyUrl());
        Log.info("Verify Url successfully");
        dragAndDropPage.drapAndDrop();
    }

    @Test
    void basicAuthTest() throws InterruptedException {
        basePage = new BasePage(driver);
        basicAuth = basePage.clickBasicAuth();
        Thread.sleep(1000);
        Assert.assertTrue(basicAuth.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
    }

    @Test
    void digestAuthTest() throws InterruptedException {
        basePage = new BasePage(driver);
        digestAuth = basePage.clickDigestAuth();
        Thread.sleep(1000);
        Assert.assertTrue(digestAuth.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
    }

    @Test
    void contextMenuTest() throws InterruptedException {
        basePage = new BasePage(driver);
        contextMenuPage = basePage.clickContextMenu();
        Thread.sleep(1000);
        Assert.assertTrue(contextMenuPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        Assert.assertTrue(contextMenuPage.contextClick());
    }

    @Test
    void entryAdTest() throws InterruptedException {
        basePage = new BasePage(driver);
        entryAdPage = basePage.clickEntryAdPage();
        Thread.sleep(1000);
        Assert.assertTrue(entryAdPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        entryAdPage.clickClose();
    }
    @Test(enabled = false)
    void exitIntentTest() throws InterruptedException, AWTException {
        basePage = new BasePage(driver);
        exitIntentPage = basePage.clickExitIntentPage();
        Thread.sleep(1000);
        Assert.assertTrue(exitIntentPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        exitIntentPage.moveOutMouse2();
    }
    @Test
    void downloadPageTest() throws InterruptedException {
        basePage = new BasePage(driver);
        downloadPage = basePage.clickDownloadPage();
        Thread.sleep(1000);
        Assert.assertTrue(downloadPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        downloadPage.download();
        Thread.sleep(5000);
    }
    @Test
    void uploadPageTest() throws InterruptedException {
        basePage = new BasePage(driver);
        uploadPage = basePage.clickUploadPage();
        Thread.sleep(1000);
        Assert.assertTrue(uploadPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        uploadPage.upload();
        Thread.sleep(5000);
    }
    @Test
    void horizontalSliderTest() throws InterruptedException {
        basePage = new BasePage(driver);
        horizontalSliderPage = basePage.clickHorizontalSliderPage();
        Thread.sleep(1000);
        Assert.assertTrue(horizontalSliderPage.verifyUrl(),"The url does not match");
        Log.info("Verify Url successfully");
        horizontalSliderPage.slide(30,0);
        Assert.assertTrue(horizontalSliderPage.verifyValue(4));
        horizontalSliderPage.leftSlide(2);
        Assert.assertTrue(horizontalSliderPage.verifyValue(3));
        horizontalSliderPage.rightSlide(3);
        Assert.assertTrue(horizontalSliderPage.verifyValue(4.5));
        Thread.sleep(5000);
    }
    @Test
    void keyPressesPageTest() throws InterruptedException {
        basePage = new BasePage(driver);
        keyPressesPage = basePage.clickKeyPressesPage();
        Assert.assertTrue(keyPressesPage.sendCtr());
        Thread.sleep(5000);
    }

    @Test
    void multipleWindowsTest() throws InterruptedException {
        basePage = new BasePage(driver);
        multipleWindows = basePage.clickMultipleWindows();
        multipleWindows.clickHereClick();
        multipleWindows.switchToWindowIndex(0);
        Thread.sleep(5000);
        multipleWindows.clickHereClick();
        multipleWindows.switchToWindowIndex(0);
        Thread.sleep(5000);
        multipleWindows.clickHereClick();
        multipleWindows.switchToWindowIndex(2);
        Thread.sleep(5000);
    }
}
