package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.pages.AccountPage;
import ru.yandex.praktikum.pages.LoginPage;
import ru.yandex.praktikum.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoggedUserTest extends BaseTest {

    User user = Util.randomUser();

    @Before
    public void createUser() {
        // System.setProperty("webdriver.chrome.driver", "/Users/svetlanakarnilaeva/Downloads/yandexdriver");
        Util.createUser(user);
    }

    @Before
    public void loginUser() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.assertThatThisIsMainPage();
    }

    @After
    public void deleteUser() {
        Util.deleteUser(user);
    }

    @Test
    @DisplayName("Переход в профиль из конструктора")
    public void accountTransitionFromConstructor() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/login", MainPage.class);
        mainPage.clickAccountButton();

        AccountPage accountPage = page(AccountPage.class);
        accountPage.assertThatThisIsAccountPage();
    }

    @Test
    @DisplayName("Переход в конструктор из профиля с помощью ссылки")
    public void constructorTransitionFromAccountByConstructorLink() {
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account", AccountPage.class);
        accountPage.clickConstructorLink();

        MainPage mainPage = page(MainPage.class);
        mainPage.assertThatThisIsMainPage();
    }

    @Test
    @DisplayName("Переход в конструктор из профиля с логотипа")
    public void constructorTransitionFromAccountByLogo() {
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account", AccountPage.class);
        accountPage.clickLogo();

        MainPage mainPage = page(MainPage.class);
        mainPage.assertThatThisIsMainPage();
    }

    @Test
    @DisplayName("Выход")
    public void logout() {
        AccountPage accountPage = open("https://stellarburgers.nomoreparties.site/account", AccountPage.class);
        accountPage.clickLogoutLink();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.assertThatThisIsLoginPage();
    }

}
