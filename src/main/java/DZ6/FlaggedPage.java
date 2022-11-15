package DZ6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlaggedPage extends BasePage {
    public FlaggedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@aria-label='Помеченные']")
    private WebElement flaggedLetter;

    @Step("Проверка помеченного письма")
    public void checkFlagLetter() {
        Assertions.assertTrue(flaggedLetter.isDisplayed());
    }
}
