package pl.umcs.testy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstAutoTest {
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.pl");
        driver.findElement(By.name("q")).sendKeys("UMCS");
        driver.findElement(By.name("q")).submit();
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("UMCS"));
    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
