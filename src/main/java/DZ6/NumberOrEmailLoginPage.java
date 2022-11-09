package DZ6;

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

    public PasswordLoginPage inputEmail(String login) {
        numberOrEmailField.sendKeys(login);
        nextButton.click();
        return new PasswordLoginPage(driver);

    }


}
