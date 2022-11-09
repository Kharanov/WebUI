package DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordLoginPage extends BasePage {
    public PasswordLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[.='Далее']")
    private WebElement nextButton;

    public GoogleWithLoginPage inputPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        nextButton.click();
        return new GoogleWithLoginPage(driver);
    }
}
