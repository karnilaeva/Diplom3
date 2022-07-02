package ru.yandex.praktikum;

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
    public void successfulLoginByLoginButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickLoginButton();

        successfulLoginTest();
    }

    @Test
    public void successfulLoginByAccountButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickAccountButton();

        successfulLoginTest();
    }

    @Test
    public void successfulLoginByRegisterView() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.clickLoginLink();

        successfulLoginTest();
    }

    @Test
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
