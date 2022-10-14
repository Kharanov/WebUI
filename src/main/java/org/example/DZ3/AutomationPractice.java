package org.example.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AutomationPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://automationpractice.com");
        login(driver);
        addToCart(driver);

        driver.quit();

    }

    public static void login(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234Qwerty@mail.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty1234");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        Thread.sleep(5000);
    }

    public static void addToCart(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//input[contains(@class,'search')]")).sendKeys("dress");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'search')]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']"));
        action.moveToElement(we).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
        Thread.sleep(2000);
    }

}

