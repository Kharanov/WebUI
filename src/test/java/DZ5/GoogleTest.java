package DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTest {
    WebDriver driver;

    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait wait;


    @BeforeAll
    public static void registeredDriver() {
        WebDriverManager.chromedriver().setup();

    }


    @BeforeEach
    void setupBrowser() {
        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Order(1)
    @Test
    void loginTest() throws InterruptedException {

        authorization(driver, wait);
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(@aria-label, 'alberteinshtein123456@gmail.com')]")).isDisplayed());
    }

    @Order(2)
    @Test
    void toWriteAndSendTest() throws InterruptedException {
        authorization(driver, wait);
        driver.findElement(By.xpath("//a[.='Почта'][1]")).click();
        actions.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Вкладка')])[1]")))
                .moveByOffset(-300, 0)
                .clickAndHold()
                .moveByOffset(500, 100)
                .keyDown(Keys.CONTROL)
                .keyDown("c")
                .keyUp(Keys.CONTROL)
                .keyUp("c")
                .perform();


        driver.findElement(By.xpath("(//div[.='Написать'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='agP aFw']")).sendKeys("AlbertEinshtein123456@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("ТЕСТ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='Текст письма']")).click();
        actions.keyDown(Keys.CONTROL)
                .keyDown("v")
                .keyUp(Keys.CONTROL)
                .keyUp("v")
                .perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@data-tooltip,'Отправить')]")).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//td[@data-tooltip='Выбрать']")).isDisplayed());

    }
    @Order(3)
    @Test
    void toCheckFlaggedMessages() throws InterruptedException {
        authorization(driver, wait);
        driver.findElement(By.xpath("//a[.='Почта'][1]")).click();
        driver.findElement(By.xpath("(//span[@data-tooltip='Не помечено'])[1]")).click();
        driver.findElement(By.xpath("//a[.='Помеченные']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@data-tooltip='Помеченные'])[2]")));
        Assertions.assertTrue(driver.findElement(By.xpath("(//span[@data-tooltip='Помеченные'])[2]")).isDisplayed());

    }

    @Test
    @Order(4)
    void toDeleteAnEmailTest() throws InterruptedException {
        authorization(driver, wait);
        driver.findElement(By.xpath("//a[.='Почта'][1]")).click();

        driver.findElement(By.xpath("//span[@role='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-tooltip='Удалить']")).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("(//div[contains(text(),'Вкладка')])[1]")).isDisplayed());
    }

    public static void authorization(WebDriver driver, WebDriverWait wait) throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("AlbertEinshtein123456@gmail.com");

        driver.findElement(By.xpath("//span[.='Далее']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("QPalzm102938");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//*[@id='passwordNext']/div/button")).click();
        Thread.sleep(3000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
