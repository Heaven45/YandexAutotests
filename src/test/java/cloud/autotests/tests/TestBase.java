package cloud.autotests.tests;

import cloud.autotests.helpers.Attach;
import cloud.autotests.helpers.DriverSettings;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
//    public void addAttachments() {
//        String sessionId = DriverUtils.getSessionId();

//        AllureAttachments.addScreenshotAs("Last screenshot");
//        AllureAttachments.addPageSource();
////        AllureAttachments.attachNetwork(); // todo
//        AllureAttachments.addBrowserConsoleLogs();
//
//        Selenide.closeWebDriver();
//
//        if (Project.isVideoOn()) {
//            AllureAttachments.addVideo(sessionId);
//        }

    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
