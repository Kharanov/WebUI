package DZ6;


import DZ7.AdditionalLogger;
import DZ7.JunitExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.ByteArrayInputStream;


//@ExtendWith(JunitExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTest {
    WebDriver driver;
    GoogleWithoutLoginPage googleWithoutLoginPage;

    @RegisterExtension
    JunitExtension testWatcher = new JunitExtension();

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        googleWithoutLoginPage = new GoogleWithoutLoginPage(driver);
        driver.get("https://www.google.com/");
    }

    @Order(1)
    @Test
    @Feature("Авторизация")
    void authorizationTest() {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .logIn();

    }

    @Order(2)
    @Test
    @Feature("Копирование и отправка текста")
    void copyWriteAndSendTest() throws InterruptedException {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .signInMail()
                .copyText()
                .clickWrite()
                .sendLetter("AlbertEinshtein123456@gmail.com", "ТЕСТ")
                .checkboxLetterV();
    }

    @Order(3)
    @Test
    @Feature("Отметка письма")
    void flagLetter() {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .signInMail()
                .flagMessage()
                .checkFlagLetter();
    }

    @Order(4)
    @Test
    @Feature("Очистка папки входящие")
    void clearInbox() throws InterruptedException {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .signInMail()
                .clearInbox();
    }

    @AfterEach
    void tearDown() {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: logs) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }
        testWatcher.setScreenshot(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }
}
