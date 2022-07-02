package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//a[contains(@href, '/login')]")
    private SelenideElement loginLink;

    public void clickLoginLink() {
        loginLink.click();
    }
}
