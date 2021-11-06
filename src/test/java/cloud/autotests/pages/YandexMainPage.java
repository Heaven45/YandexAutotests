package cloud.autotests.pages;

import cloud.autotests.helpers.DateTimeHelper;
import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class YandexMainPage {

    DateTimeHelper date = new DateTimeHelper();

    @Step("Open main page")
    public YandexMainPage openPage() {
        open("https://yandex.ru/");
        String expectedTitle = "Яндекс";
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(expectedTitle);
        return this;
    }

    @Step("Open tab {tabName}")
    public YandexMainPage openTab(String tabName) {
        $("[data-id='" + tabName + "']").click();
        return this;
    }

    @Step("Switch to opened tab")
    public YandexMainPage switchToOpenedTab() {
        switchTo().window(1);
        return this;
    }

    @Step("Check if tab has correct title")
    public YandexMainPage checkTitle(String expectedTitle) {
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(expectedTitle);
        return this;
    }

    @Step("Check if day, month and day of the week are correct")
    public YandexMainPage checkDateAndTime() {
        assertThat($(".datetime__day").getText()).isEqualTo(date.currentDay.toString());
        assertThat($(".datetime__month").getText()).isEqualTo(date.currentMonth + ",");
        assertThat($(".datetime__wday").getText()).isEqualTo(date.currentDayOfWeek);
        // TODO Сделать аналогичные проверки с часами и минутами ".datetime__hour", ".datetime__min"
        return this;
    }

    @Step("Check console log for errors")
    public YandexMainPage consoleShouldNotHaveErrors() {
        String consoleLogs = DriverUtils.getConsoleLogs();
        String errorText = "SEVERE";

        assertThat(consoleLogs).doesNotContain(errorText);
        return this;
    }

    @Step("Check if set home button is present")
    public YandexMainPage checkSetHome() {
        $(".b-sethome").$(withText("Сделать стартовой")).shouldBe(visible);
        return this;
    }

    @Step("Click on 'login' button")
    public YandexMainPage clickLoginButton() {
        $(".desk-notif-card__login-new-item-title").click();
        return this;
    }

    @Step("Check yandex pasport title")
    public YandexMainPage assertYandexPassportPageIsOpened() {
        $(".passp-auth-content").should(exist);
        return this;
    }
}
