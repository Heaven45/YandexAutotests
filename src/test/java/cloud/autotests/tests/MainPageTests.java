package cloud.autotests.tests;

import cloud.autotests.pages.YandexMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MainPageTests extends TestBase {

    YandexMainPage mainPage = new YandexMainPage();

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        mainPage.openPage()
                .consoleShouldNotHaveErrors();
    }

    @CsvSource(value = {
            "market; Яндекс.Маркет — покупки с быстрой доставкой",
            "video; видео: 4 тыс. видео найдено в Яндексе",
            "images; Яндекс.Картинки: поиск изображений в интернете, поиск по изображению",
            "news; Яндекс.Новости: Главные новости сегодня, самые свежие и последние новости России онлайн",
            "maps; Яндекс.Карты — транспорт, навигация, поиск мест",
            "translate; Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.",
            "music; Яндекс.Музыка — собираем музыку и подкасты для вас",
            "tv; Программа передач ТВ — Яндекс.Телепрограмма",
            "autoru; Авто.ру: купить, продать и обменять машину"
    }, delimiter = ';')

    @ParameterizedTest
    @DisplayName("Open all tabs")
    void pageTest(String tabName, String expectedTitle) {
        mainPage.openPage()
                .openTab(tabName)
                .checkTitle(expectedTitle);
    }

    @Test
    @DisplayName("Check time and date")
    void checkIfTimeIsCorrect() {
        mainPage.openPage()
                .checkDateAndTime();
    }
}