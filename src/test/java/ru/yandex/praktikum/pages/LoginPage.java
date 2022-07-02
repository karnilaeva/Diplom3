package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // локатор поля "Email"
    @FindBy(how = How.XPATH, using = "//input[contains(@name, 'name')]")
    private SelenideElement emailField;

    // локатор поля "Пароль"
    @FindBy(how = How.XPATH, using = "//input[contains(@name, 'Пароль')]")
    private SelenideElement passwordField;

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')]")
    private SelenideElement loginButton;

    public void setEmail(String name) {
        emailField.setValue(name);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
