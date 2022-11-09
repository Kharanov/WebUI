package DZ6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewLetterPage extends BasePage {
    public NewLetterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@aria-haspopup='listbox']")
    private WebElement inputWhom;

    @FindBy(xpath = "//input[@aria-label='Тема']")
    private WebElement inputTopic;

    @FindBy(xpath = "//div[@aria-label='Текст письма']")
    private WebElement inputTextLetter;
    @FindBy(xpath = "//div[contains(@data-tooltip,'Отправить')]")
    private WebElement sendButton;

    public GoogleMailMainPage sendLetter(String whom, String topic) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(inputTopic));
        inputWhom.sendKeys(whom);
        inputTopic.sendKeys(topic);
        inputTextLetter.click();
        actions.keyDown(Keys.CONTROL).keyDown("v").keyUp(Keys.CONTROL).keyUp("v").perform();
        sendButton.click();
        Thread.sleep(2000);
        return new GoogleMailMainPage(driver);

    }
}
