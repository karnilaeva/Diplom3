package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    // локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//a[contains(@href, '/account')]")
    private SelenideElement accountButton;

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void assertThatThisIsMainPage() {
        $(".BurgerIngredients_ingredients__1N8v2").shouldBe(visible);
    }

}
