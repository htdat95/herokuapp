package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.awt.*;

public class Suite1 extends BaseTest{
    WebDriver driver;
    CheckBoxPage checkBoxPage;
    BasePage basePage;
    AddRemovePage addRemovePage;
    BrokenImagePage brokenImagePage;
    JavaAlert javaAlert;
    DisappearElement disappearElement;
    DynamicallyLoadedPage dynamicallyLoadedPage;
    DynamicControlsPage dynamicControlsPage;
    UploadPage uploadPage;
    NestedFramePage nestedFramePage;
    GeoLocationPage geoLocationPage;
    HoversPage hoversPage;
    InfiniteScrollPage infiniteScrollPage;
    JQueryUIMenuPage jQueryUIMenuPage;
    TablePage tablePage;
    SecureFileDownloadPage secureFileDownloadPage;
@BeforeClass
public void initBrowser(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless");
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
    void checkBoxTest(){
        String tcId = "checkBoxTest";
        Log.info("tcId: 'checkBoxTest' ----> Entering test case");
        basePage = new BasePage(driver);
        checkBoxPage = basePage.clickCheckbox();
        Log.info("tcId: 'checkBoxTest' ----> Click check box url successfully");
        Assert.assertTrue(checkBoxPage.verifyUrl());
        Log.info("tcId: 'checkBoxTest' ----> Verify url");
        Assert.assertTrue(checkBoxPage.selectAllCheckBox());
        Log.info("tcId: 'checkBoxTest' ----> Verify all check box have been checked");
    }

    @Test
    void addElementTest() throws InterruptedException {
        String tcId = "addElementTest";
        Log.info("tcId: 'addElementTest' ----> Entering test case");
        basePage = new BasePage(driver);
        addRemovePage = basePage.clickAddRemove();
        Assert.assertTrue(addRemovePage.verifyUrl());
        Log.info("tcId: 'addElementTest' ----> Verify url");
        addRemovePage.addElement(6);
        Log.info("tcId: 'addElementTest' ----> add 6 elements");
        Assert.assertTrue(addRemovePage.verifyElementsExisted(6));
        Log.info("tcId: 'addElementTest' ----> verify 6 elements existed");
        addRemovePage.deleteElement(4);
        Log.info("tcId: 'addElementTest' ----> remove 4 elements");
        Assert.assertTrue(addRemovePage.verifyElementsExisted(2));
        Log.info("tcId: 'addElementTest' ----> verify 2 elements existed");
    }

    @Test
    void brokenImageTest() throws InterruptedException {
        String tcId = "brokenImageTest";
        Log.info("tcId: 'brokenImageTest' ----> Entering test case");
        basePage = new BasePage(driver);
        brokenImagePage = basePage.clickBrokenImage();
        Assert.assertTrue(brokenImagePage.verifyUrl());
        Log.info("tcId: 'brokenImageTest' ----> Verify url");
        brokenImagePage.checkImageBroken();
        Log.info("tcId: 'brokenImageTest' ----> check broken Image");
    }

    @Test
    void javaAlertTest() throws InterruptedException {
        String tcId = "javaAlertTest";
        Log.info(tcId +": 'javaAlertTest' ----> Entering test case");
        basePage = new BasePage(driver);
        javaAlert = basePage.clickJSAlert();
        Assert.assertTrue(javaAlert.verifyUrl());
        Log.info(tcId +": 'brokenImageTest' ----> Verify url");
        javaAlert.clickOkOnJSAlert();
        Assert.assertTrue(javaAlert.checkNotification("You successfully clicked an alert"));
        Thread.sleep(1000);
        Assert.assertTrue(javaAlert.clickOkOnJSConfirm());
        Assert.assertTrue(javaAlert.checkNotification("You clicked: Ok"));
        Thread.sleep(1000);
        Assert.assertTrue(javaAlert.clickCancelOnJSConfirm());
        Assert.assertTrue(javaAlert.checkNotification("You clicked: Cancel"));
        Thread.sleep(1000);
        Assert.assertTrue(javaAlert.sendKeyToJSPrompt("abcdef"));
        Assert.assertTrue(javaAlert.checkNotification("You entered: abcdef"));
        Thread.sleep(1000);
    }

    @Test
    void disappearElementTest() throws InterruptedException {
        String tcId = "disappearElementTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        disappearElement = basePage.clickDisappearElement();
        Assert.assertTrue(disappearElement.verifyUrl());
        Log.info(tcId +": ----> Verify url");
        disappearElement.reload_toGet_allElement();
        Log.info(tcId +": ----> check broken Image");
    }
    @Test
    void dynamicControlsTest() throws InterruptedException {
        String tcId = "dynamicControlsTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        dynamicControlsPage = basePage.clickDynamicControlsPage();
        Assert.assertTrue(dynamicControlsPage.verifyUrl());
        Log.info(tcId +": ----> Verify url");
//        Assert.assertTrue(dynamicControlsPage.removeElement());
//        Assert.assertTrue(dynamicControlsPage.tickCheckbox());
        Assert.assertTrue(dynamicControlsPage.tickEnable("aaa"));
    }

    @Test
    void nestedFrameTest() throws InterruptedException {
        String tcId = "nestedFrameTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        nestedFramePage = basePage.clickNestedFramePage();
        nestedFramePage.switchToFrame("frame-top");
//        nestedFramePage.switchToFrame("frameset-middle");  frameset k tinh la frame
        nestedFramePage.switchToFrame("frame-right");
        Assert.assertTrue(nestedFramePage.verifyFrameText("frame-right","RIGHT"));
    }

    @Test
    void dynamicallyLoadedTest() throws InterruptedException {
        String tcId = "dynamicControlsTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        dynamicallyLoadedPage = basePage.clickDynamicallyLoadedPage();
        Assert.assertTrue(dynamicallyLoadedPage.verifyUrl());
        Log.info(tcId +": ----> Verify url");
        dynamicallyLoadedPage.clickLink(1);
        Assert.assertTrue(dynamicallyLoadedPage.clickStart(),"element doesn't display");
    }
    @Test
    void geoLocationTest() throws InterruptedException {
        String tcId = "geoLocationTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        geoLocationPage = basePage.clickGeoLocationPage();
//        geoLocationPage.acceptShareLocation();
        geoLocationPage.emulateGeolocation();
        Thread.sleep(10000);
    }
    @Test
    void hoversTest() throws InterruptedException {
        String tcId = "hoversTest";
        String expectedUrl = String.format("https://the-internet.herokuapp.com/users/3");
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        hoversPage = basePage.clickHoversPage();
        hoversPage.clickHoverUser(3);
        Assert.assertEquals(expectedUrl,hoversPage.getUrl());
    }
    @Test
    void infiniteScrollPageTest() throws InterruptedException, AWTException {
        String tcId = "infiniteScrollPageTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        infiniteScrollPage = basePage.clickInfiniteScrollPage();
        infiniteScrollPage.scrollTo2();
        Thread.sleep(5000);
   }
    @Test(enabled = false)
    void jQueryUIMenuTest() throws InterruptedException {
        String tcId = "jQueryUIMenuTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        jQueryUIMenuPage = basePage.clickJQueryUIMenuPage();
        jQueryUIMenuPage.moveToSecondSubMenu("PDF");
        Thread.sleep(5000);
    }
    @Test
    void TablePageTest() throws InterruptedException {
        String tcId = "TablePageTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        tablePage = basePage.clickTablePage();
        Assert.assertEquals(tablePage.min(),"Jason");
        Thread.sleep(5000);
    }
    @Test
    void SecureFileDownloadPageTest() throws InterruptedException {
        String tcId = "SecureFileDownloadPageTest";
        Log.info(tcId +": ----> Entering test case");
        basePage = new BasePage(driver);
        secureFileDownloadPage = basePage.clickSecureFileDownloadPage();
        Thread.sleep(5000);
    }
}
