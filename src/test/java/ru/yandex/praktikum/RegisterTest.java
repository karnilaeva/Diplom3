package ru.yandex.praktikum;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.pages.RegisterPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;

    @Before
    public void openPage() {
//        System.setProperty("webdriver.chrome.driver", "/Users/svetlanakarnilaeva/Downloads/yandexdriver");
        registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
    }

    @Test
    public void successfulRegistration() {
        User user = Util.randomUser();

        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword(user.getPassword());
        registerPage.clickRegisterButton();

        $(By.xpath("//*[text()='Вход']")).shouldBe(visible);
        assertNotNull(Util.getToken(user));

        Util.deleteUser(user);
    }

    @Test
    public void shortPassword() {
        User user = Util.randomUser("12345");

        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword(user.getPassword());
        registerPage.clickRegisterButton();

        $(By.xpath("//*[text()='Некорректный пароль']")).shouldBe(visible);
        assertNull(Util.getToken(user));
    }

}
