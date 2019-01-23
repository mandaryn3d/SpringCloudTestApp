package pl.umcs.testy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class FormularzAutoTest {
    private WebDriver driver;
    private final String FIRST_NAME = "umcs imie";
    private final String LAST_NAME = "umcs nazwisko";
    private final String ADDRESS = "UMCS adres";
    private final String EMAIL = "umcs@umcs.pl";
    private final String PHONE = "2594744216";
    private final String PASSWORD = "Password1";
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void fillForm() {
        driver.navigate().to("http://demo.automationtesting.in/Register.html");
        WebElement firstName = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
        WebElement address = driver.findElement(By.xpath("//*[@ng-model='Adress']"));
        WebElement email = driver.findElement(By.xpath("//*[@ng-model='EmailAdress']"));
        WebElement phone = driver.findElement(By.xpath("//*[@ng-model='Phone']"));
        WebElement gender = driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']"));
        WebElement hobbies = driver.findElement(By.xpath("//*[@id='checkbox2']"));
        WebElement skill = driver.findElement(By.xpath("//*[@id='Skills']"));
        WebElement country = driver.findElement(By.xpath("//*[@id='countries']"));
        WebElement countrySelect = driver.findElement(By.xpath("//*[@aria-labelledby='select2-country-container']"));
        WebElement yearSelector = driver.findElement(By.xpath("//*[@id='yearbox']"));
        WebElement monthSelector = driver.findElement(By.xpath("//*[@ng-model='monthbox']"));
        WebElement daySelector = driver.findElement(By.xpath("//*[@ng-model='daybox']"));
        WebElement firstPassword = driver.findElement(By.xpath("//*[@id='firstpassword']"));
        WebElement secondPassword = driver.findElement(By.xpath("//*[@id='secondpassword']"));

        firstName.sendKeys(FIRST_NAME);
        lastName.sendKeys(LAST_NAME);
        address.sendKeys(ADDRESS);
        email.sendKeys(EMAIL);
        phone.sendKeys(PHONE);
        gender.click();
        hobbies.click();
        driver.findElement(By.xpath("//*[@id='msdd']")).click();
        driver.findElement(By.xpath("//li[contains(@class,'ng-scope')][8]/a")).click();
        selectTheDropDownList(skill, "C++");
        selectTheDropDownList(country, "Poland");
        countrySelect.click();
        driver.findElement(By.xpath("//*[@id='select2-country-results']/li[1]")).click();
        selectTheDropDownList(yearSelector, "1995");
        selectTheDropDownList(monthSelector, "December");
        selectTheDropDownList(daySelector, "12");
        firstPassword.sendKeys(PASSWORD);
        secondPassword.sendKeys(PASSWORD);
        driver.findElement(By.xpath("//*[@id='submitbtn']")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String confirmText = driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/h4[1]/b")).getText();
        assertEquals(confirmText, "EDIT");
    }
    public static void selectTheDropDownList(WebElement dropDown,String text)
    {
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
