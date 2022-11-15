package DZ6;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleMailMainPage extends BasePage {
    public GoogleMailMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'\"Несортированные\"')]")
    private WebElement copyText;

    public GoogleMailMainPage copyText() {
        wait.until(ExpectedConditions.visibilityOf(copyText));
        Allure.step("Копирование текста");
        actions.moveToElement(copyText)
                .moveByOffset(-300, 0)
                .clickAndHold()
                .moveByOffset(500, 100)
                .keyDown(Keys.CONTROL)
                .keyDown("c")
                .keyUp(Keys.CONTROL)
                .keyUp("c")
                .perform();
        return new GoogleMailMainPage(driver);
    }

    @FindBy(xpath = "//div[@style='user-select: none']")
    private WebElement clickWrite;

    public NewLetterPage clickWrite() {
        clickWrite.click();
        return new NewLetterPage(driver);
    }

    @FindBy(xpath = "//td[@data-tooltip='Выбрать']")
    private WebElement checkboxLetter;

    public void checkboxLetterV() {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxLetter));
        Assertions.assertTrue(checkboxLetter.isDisplayed());
    }

    @FindBy(xpath = "//span[@data-tooltip='Не помечено']")
    private WebElement noFlag;

    @FindBy(xpath = "//div[@data-tooltip='Помеченные']")
    private WebElement FlaggedLetter;

    public FlaggedPage flagMessage() {
        Allure.step("Отметить входящее");
        noFlag.click();
        Allure.step("Перейти в папку Помеченные");
        FlaggedLetter.click();
        return new FlaggedPage(driver);
    }

    @FindBy(xpath = "//span[@role='checkbox']")
    private WebElement checkboxAllLetter;

    @FindBy(xpath = "//div[@data-tooltip='Удалить']")
    private WebElement deleteAll;

    @FindBy(xpath = "//*[.='Раздел для личных сообщений и писем, которые не попали в другие категории.']")
    private WebElement inboxCleaned;

    @Step("Очистка папки 'Входящие' ")
    public void clearInbox() throws InterruptedException {
        Allure.step("Выбрать все письма");
        checkboxAllLetter.click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteAll));
        Allure.step("Удалить все входящие");
        deleteAll.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(inboxCleaned));
        Assertions.assertTrue(inboxCleaned.isDisplayed());

    }


}