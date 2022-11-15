package DZ6;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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

    @Step("Ввод пароля")
    public GoogleWithLoginPage inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        Allure.step("Ввод Пароля");
        passwordField.sendKeys(password);
        Allure.step("Клик далее");
        nextButton.click();
        return new GoogleWithLoginPage(driver);
    }
}
