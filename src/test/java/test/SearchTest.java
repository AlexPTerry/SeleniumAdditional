package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchTest {

    private static WebDriver driver;
    private static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/";

    @BeforeClass
    public static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        // Need to accept the pesky cookies at least once
        driver.get(URL);

        WebElement acceptCookieButton = driver.findElement(By.id("acceptCookieButton"));
        acceptCookieButton.click();

        System.out.println("Starting...");
    }

    @Test
    public void getTopRiserTest() {
        driver.get(URL);

        WebElement risers = driver.findElement(By.cssSelector("[title='View risers']"));
        risers.click();

        WebElement topRiser = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        System.out.println("Top riser: " + topRiser.getText());
    }

    @Test
    public void getTopFallerTest() {
        driver.get(URL);

        WebElement risers = driver.findElement(By.cssSelector("[title='View fallers']"));
        risers.click();

        WebElement topFaller = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        System.out.println("Top faller: " + topFaller.getText());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        System.out.println("Quiting...");
    }
}
