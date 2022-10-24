package DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeTest {
    WebDriver driver;

    ChromeOptions chromeOptions;
    Actions action;


    @BeforeAll
    public static void registeredDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupBrowser(){
        chromeOptions = new ChromeOptions();
//      chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        action = new Actions(driver);
    }

    @Test
    void loginTest() throws InterruptedException {
        authorization(driver);
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Welcome')]")).isDisplayed());
    }

    @Test
    void addToCartTest() throws InterruptedException {
        authorization(driver);
        driver.findElement(By.xpath("//input[contains(@class,'search')]")).sendKeys("dress");
        driver.findElement(By.xpath("//button[contains(@class,'search')]")).click();
        WebElement we = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']"));
        action.moveToElement(we).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[.='Add to cart'])[1]")).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("(//h2[contains(text(),'')])[1]")).isDisplayed());
    }


    public static void authorization(WebDriver driver) throws InterruptedException {

        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234Qwerty@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty1234");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}



