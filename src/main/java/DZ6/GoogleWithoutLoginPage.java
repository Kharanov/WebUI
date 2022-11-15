package DZ6;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class GoogleWithoutLoginPage extends BasePage {

    @FindBy(xpath = "//a[.='Войти']")
    public WebElement signInButton;

    public GoogleWithoutLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вход")
    public NumberOrEmailLoginPage clickSignInButton() {
        Allure.step("Вход клик");
        signInButton.click();
        return new NumberOrEmailLoginPage(driver);
    }
}
