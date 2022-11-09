package DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class GoogleWithoutLoginPage extends BasePage{

    @FindBy(xpath = "//a[.='Войти']")
    public WebElement signInButton;

    public GoogleWithoutLoginPage(WebDriver driver) {
        super(driver);
    }

    public NumberOrEmailLoginPage clickSignInButton() {
        signInButton.click();
        return new NumberOrEmailLoginPage(driver);
    }
}
