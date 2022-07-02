package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    // локатор поля "Имя"
    @FindBy(how = How.XPATH, using = "(//input[contains(@name, 'name')])[1]")
    private SelenideElement nameField;

    // локатор поля "Email"
    @FindBy(how = How.XPATH, using = "(//input[contains(@name, 'name')])[2]")
    private SelenideElement emailField;

    // локатор поля "Пароль"
    @FindBy(how = How.XPATH, using = "//input[contains(@name, 'Пароль')]")
    private SelenideElement passwordField;

    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')]")
    private SelenideElement registerButton;

    public void setName(String name) {
        nameField.setValue(name);
    }

    public void setEmail(String email) {
        emailField.setValue(email);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

}
