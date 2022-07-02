package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pages.MainPage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void openPage() {
//        System.setProperty("webdriver.chrome.driver", "/Users/svetlanakarnilaeva/Downloads/yandexdriver");
        mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
    }

    @Test
    public void sectionsSelect() {
        String selectedClass = "tab_tab_type_current__2BEPc";

        mainPage.getBunsLink().shouldHave(cssClass(selectedClass));
        mainPage.getSousesLink().shouldNotHave(cssClass(selectedClass));
        mainPage.getFillingsLink().shouldNotHave(cssClass(selectedClass));

        mainPage.clickSousesLink();
        mainPage.getBunsLink().shouldNotHave(cssClass(selectedClass));
        mainPage.getSousesLink().shouldHave(cssClass(selectedClass));
        mainPage.getFillingsLink().shouldNotHave(cssClass(selectedClass));

        mainPage.clickFillingsLink();
        mainPage.getBunsLink().shouldNotHave(cssClass(selectedClass));
        mainPage.getSousesLink().shouldNotHave(cssClass(selectedClass));
        mainPage.getFillingsLink().shouldHave(cssClass(selectedClass));

        mainPage.clickBunsLink();
        mainPage.getBunsLink().shouldHave(cssClass(selectedClass));
        mainPage.getSousesLink().shouldNotHave(cssClass(selectedClass));
        mainPage.getFillingsLink().shouldNotHave(cssClass(selectedClass));
    }
}
