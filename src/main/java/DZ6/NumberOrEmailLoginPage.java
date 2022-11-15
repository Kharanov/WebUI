package DZ6;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class NumberOrEmailLoginPage extends BasePage {

    public NumberOrEmailLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement numberOrEmailField;

    @FindBy(xpath = "//span[.='Далее']")
    private WebElement nextButton;

    @Step("Ввод Email")
    public PasswordLoginPage inputEmail(String login) {
        Allure.step("Ввод емэйла");
        numberOrEmailField.sendKeys(login);
        Allure.step("Клик Далее");
        nextButton.click();
        return new PasswordLoginPage(driver);

    }


}
