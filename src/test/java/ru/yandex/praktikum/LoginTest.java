package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.pages.ForgotPasswordPage;
import ru.yandex.praktikum.pages.LoginPage;
import ru.yandex.praktikum.pages.MainPage;
import ru.yandex.praktikum.pages.RegisterPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    User user = Util.randomUser();

    @Before
    public void createUser() {
        // System.setProperty("webdriver.chrome.driver", "/Users/svetlanakarnilaeva/Downloads/yandexdriver");
        Util.createUser(user);
    }

    @After
    public void deleteUser() {
        Util.deleteUser(user);
    }

    @Test
    @DisplayName("Успешный вход по кнопке 'Войти в аккаунт'")
    public void successfulLoginByLoginButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickLoginButton();

        successfulLoginTest();
    }

    @Test
    @DisplayName("Успешный вход по кнопке 'Личный кабинет'")
    public void successfulLoginByAccountButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickAccountButton();

        successfulLoginTest();
    }

    @Test
    @DisplayName("Успешный вход из окна регистрации")
    public void successfulLoginByRegisterView() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.clickLoginLink();

        successfulLoginTest();
    }

    @Test
    @DisplayName("Успешный вход из окна восстановления пароля")
    public void successfulLoginByForgotPasswordView() {
        ForgotPasswordPage forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginLink();

        successfulLoginTest();
    }

    private void successfulLoginTest() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.assertThatThisIsMainPage();
        mainPage.getLoginButton().shouldNotBe(visible);
    }
}
