package org.example.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Mail {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com/");
        login(driver);
        toWriteAndSend(driver);
        toDeleteAnEmail(driver);



        driver.quit();

    }

    public static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("AlbertEinshtein123456@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Далее']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("QPalzm102938");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='passwordNext']/div/button")).click();
        Thread.sleep(2000);
    }

    public static void toDeleteAnEmail(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//div[@role='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=':4']/div/div[1]/div[1]/div/div/div[2]/div[3]/div")).click();
        Thread.sleep(2000);
    }

    public static void toWriteAndSend(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Почта'][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[.='Написать']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='agP aFw']")).sendKeys("AlbertEinshtein123456@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("ТЕСТ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='Текст письма']")).sendKeys("Проверка");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@data-tooltip,'Отправить')]")).click();
        Thread.sleep(2000);

    }

}
