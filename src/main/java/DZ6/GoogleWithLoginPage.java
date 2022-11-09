package DZ6;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleWithLoginPage extends BasePage {
    public GoogleWithLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@aria-label, 'alberteinshtein123456@gmail.com')]")
    private WebElement login;

    @FindBy(xpath = "//div/a[.='Почта']")
    private WebElement mailButton;

    public void logIn() {
        wait.until(ExpectedConditions.visibilityOf(login));
        Assertions.assertTrue(login.isDisplayed());
    }
    public GoogleMailMainPage signInMail() {
        wait.until(ExpectedConditions.visibilityOf(mailButton));
        mailButton.click();
        return new GoogleMailMainPage(driver);
    }
}
