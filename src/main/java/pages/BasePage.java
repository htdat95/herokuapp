package pages;


import io.qameta.allure.Step;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class BasePage{
    private WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMillis(60));
    }

    private final By checkboxesLink = By.linkText("Checkboxes");
    private final By dropdownLink = By.linkText("Dropdown");
    private final By dragAndDropLink = By.linkText("Drag and Drop");
    private final By abTestingLink = By.linkText("A/B Testing");
    private final By addRemoveLink = By.linkText("Add/Remove Elements");
    private final By basicAuthLink = By.linkText("Basic Auth");
    private final By brokenImagesLink = By.linkText("Broken Images");
    private final By challengingDomLink = By.linkText("Challenging DOM");
    private final By contextMenuLink = By.linkText("Context Menu");
    private final By digestAuthenticationLink = By.linkText("Digest Authentication");
    private final By disappearingElementsLink = By.linkText("Disappearing Elements");
    private final By dynamicContentLink = By.linkText("Dynamic Content");
    private final By dynamicControlsLink = By.linkText("Dynamic Controls");
    private final By dynamicLoadingLink = By.linkText("Dynamic Loading");
    private final By entryAdLink = By.linkText("Entry Ad");
    private final By exitIntentLink = By.linkText("Exit Intent");
    private final By fileDownloadLink = By.linkText("File Download");
    private final By fileUploadLink = By.linkText("File Upload");
    private final By floatingMenuLink = By.linkText("Floating Menu");
    private final By forgotPasswordLink = By.linkText("Forgot Password");
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By framesLink = By.linkText("Frames");
    private final By geolocationLink = By.linkText("Geolocation");
    private final By horizontalSliderLink = By.linkText("Horizontal Slider");
    private final By hoversLink = By.linkText("Hovers");
    private final By infiniteScrollLink = By.linkText("Infinite Scroll");
    private final By inputsLink = By.linkText("Inputs");
    private final By jQueryUiMenusLink = By.linkText("JQuery UI Menus");
    private final By javaScriptAlertsLink = By.linkText("JavaScript Alerts");
    private final By javaScriptOnloadEventErrorLink = By.linkText("JavaScript onload event error");
    private final By keyPressesLink = By.linkText("Key Presses");
    private final By largeAndDeepDOMLink = By.linkText("Large & Deep DOM");
    private final By multipleWindowsLink = By.linkText("Multiple Windows");
    private final By nestedFramesLink = By.linkText("Nested Frames");
    private final By notificationMessagesLink = By.linkText("Notification Messages");
    private final By redirectLink = By.linkText("Redirect Link");
    private final By secureFileDownloadLink = By.linkText("Secure File Download");
    private final By shadowDomLink = By.linkText("Shadow DOM");
    private final By shiftingContentLink = By.linkText("Shifting Content");
    private final By slowResourcesLink = By.linkText("Slow Resources");
    private final By sortableDataTablesLink = By.linkText("Sortable Data Tables");
    private final By typosLink = By.linkText("Typos");
    private final By wysiwygEditorLink = By.linkText("WYSIWYG Editor");
    private final By statusCodesLink = By.linkText("Status Codes");


    @Step("Clicking the 'Checkbox' linkText")
    public CheckBoxPage clickCheckbox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkboxesLink));
        driver.findElement(checkboxesLink).click();
        return new CheckBoxPage(driver);
    }

    @Step("Click the 'DorpDown' linkText")
    public DropDownPage clickDropDown(){
        wait.until(ExpectedConditions.elementToBeClickable(dropdownLink));
        driver.findElement(dropdownLink).click();
        return new DropDownPage(driver);
    }
    @Step("Click the 'DragAndDrop' linkText")
    public DragAndDropPage clickDragAndDrop(){
        wait.until(ExpectedConditions.elementToBeClickable(dragAndDropLink));
        driver.findElement(dragAndDropLink).click();
        return new DragAndDropPage(driver);
    }

    public AddRemovePage clickAddRemove(){
        wait.until(ExpectedConditions.elementToBeClickable(addRemoveLink));
        driver.findElement(addRemoveLink).click();
        return new AddRemovePage(driver);
    }

    public BasicAuth clickBasicAuth(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
        wait.until(ExpectedConditions.elementToBeClickable(basicAuthLink));
        driver.findElement(basicAuthLink).click();
        return new BasicAuth(driver);
    }
    public DigestAuth clickDigestAuth(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
        wait.until(ExpectedConditions.elementToBeClickable(digestAuthenticationLink));
        driver.findElement(digestAuthenticationLink).click();
        return new DigestAuth(driver);
    }
    public BrokenImagePage clickBrokenImage(){
        wait.until(ExpectedConditions.elementToBeClickable(brokenImagesLink));
        driver.findElement(brokenImagesLink).click();
        return new BrokenImagePage(driver);
    }

    public JavaAlert clickJSAlert(){
        wait.until(ExpectedConditions.elementToBeClickable(javaScriptAlertsLink));
        driver.findElement(javaScriptAlertsLink).click();
        return new JavaAlert(driver);
    }
    public ContextMenuPage clickContextMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(contextMenuLink)).click();
        return new ContextMenuPage(driver);
    }

    public DisappearElement clickDisappearElement(){
        wait.until(ExpectedConditions.elementToBeClickable(disappearingElementsLink)).click();
        return new DisappearElement(driver);
    }
    public DynamicControlsPage clickDynamicControlsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsLink)).click();
        return new DynamicControlsPage(driver);
    }

    public DynamicallyLoadedPage clickDynamicallyLoadedPage(){
        wait.until(ExpectedConditions.elementToBeClickable(dynamicLoadingLink)).click();
        return new DynamicallyLoadedPage(driver);
    }

    public EntryAdPage clickEntryAdPage(){
        wait.until(ExpectedConditions.elementToBeClickable(entryAdLink)).click();
        return new EntryAdPage(driver);
    }
    public ExitIntentPage clickExitIntentPage(){
        wait.until(ExpectedConditions.elementToBeClickable(exitIntentLink)).click();
        return new ExitIntentPage(driver);
    }
    public DownloadPage clickDownloadPage(){
        wait.until(ExpectedConditions.elementToBeClickable(fileDownloadLink)).click();
        return new DownloadPage(driver);
    }
    public UploadPage clickUploadPage(){
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadLink)).click();
        return new UploadPage(driver);
    }
    public NestedFramePage clickNestedFramePage(){
        wait.until(ExpectedConditions.elementToBeClickable(nestedFramesLink)).click();
        return new NestedFramePage(driver);
    }

    public GeoLocationPage clickGeoLocationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(geolocationLink)).click();
        return new GeoLocationPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderPage(){
        wait.until(ExpectedConditions.elementToBeClickable(horizontalSliderLink)).click();
        return new HorizontalSliderPage(driver);
    }
    public HoversPage clickHoversPage(){
        wait.until(ExpectedConditions.elementToBeClickable(hoversLink)).click();
        return new HoversPage(driver);
    }
    public InfiniteScrollPage clickInfiniteScrollPage(){
        wait.until(ExpectedConditions.elementToBeClickable(infiniteScrollLink)).click();
        return new InfiniteScrollPage(driver);
    }
    public JQueryUIMenuPage clickJQueryUIMenuPage(){
        wait.until(ExpectedConditions.elementToBeClickable(jQueryUiMenusLink)).click();
        return new JQueryUIMenuPage(driver);
    }
    public KeyPressesPage clickKeyPressesPage(){
        wait.until(ExpectedConditions.elementToBeClickable(keyPressesLink)).click();
        return new KeyPressesPage(driver);
    }
    public TablePage clickTablePage(){
        wait.until(ExpectedConditions.elementToBeClickable(sortableDataTablesLink)).click();
        return new TablePage(driver);
    }
    public MultipleWindows clickMultipleWindows(){
        wait.until(ExpectedConditions.elementToBeClickable(multipleWindowsLink)).click();
        return new MultipleWindows(driver);
    }
    public SecureFileDownloadPage clickSecureFileDownloadPage(){
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));
        wait.until(ExpectedConditions.elementToBeClickable(secureFileDownloadLink)).click();
        return new SecureFileDownloadPage(driver);
    }
}
