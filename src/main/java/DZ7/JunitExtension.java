package DZ7;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class JunitExtension implements TestWatcher {
    ByteArrayInputStream screenshot;

    public void setScreenshot(ByteArrayInputStream screenshot) {
        this.screenshot = screenshot;
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Скриншот при падении", screenshot);
    }
}
