package DZ6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTest {
    WebDriver driver;
    GoogleWithoutLoginPage googleWithoutLoginPage;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        googleWithoutLoginPage = new GoogleWithoutLoginPage(driver);
        driver.get("https://www.google.com/");
    }

    @Order(1)
    @Test
    void authorizationTest() {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .logIn();

    }

    @Order(2)
    @Test
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
    void clearInbox() throws InterruptedException {
        googleWithoutLoginPage.clickSignInButton()
                .inputEmail("AlbertEinshtein123456@gmail.com")
                .inputPassword("QPalzm102938")
                .signInMail()
                .clearInbox();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
