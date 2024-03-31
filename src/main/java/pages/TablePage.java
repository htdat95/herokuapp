package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sub.Persons;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TablePage {
    public TablePage(WebDriver driver) {
        this.driver = driver;
    }
    List<Persons> personsList;
    private final WebDriver driver;
     void setup(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        personsList = rows.stream()
                .map(this::toPerson)
                .collect(Collectors.toList());
    }
    public String min (){
         setup();
        Persons minPersons = personsList.stream()
                .min(Comparator.comparing(Persons::getDue))
                .orElseThrow(NoSuchElementException::new);
        return minPersons.getFirstName();
    }
    private Persons toPerson(WebElement element){
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstname = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        float due = Float.parseFloat(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Persons(lastName,firstname,email,website,due);
    }
    public String max(){
        Persons maxPersons = personsList.stream()
                .max(Comparator.comparing(Persons::getDue))
                .orElseThrow(NoSuchElementException::new);
        return maxPersons.getWebsite();
    }
}
