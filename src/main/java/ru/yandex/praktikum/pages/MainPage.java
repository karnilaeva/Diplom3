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

    // локатор ссылки "Булки"
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'tab_tab__1SPyG')])[1]")
    private SelenideElement bunsLink;

    // локатор ссылки "Соусы"
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'tab_tab__1SPyG')])[2]")
    private SelenideElement sousesLink;

    // локатор ссылки "Начинки"
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'tab_tab__1SPyG')])[3]")
    private SelenideElement fillingsLink;

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public SelenideElement getBunsLink() {
        return bunsLink;
    }

    public void clickBunsLink() {
        bunsLink.$("span").click();
    }

    public SelenideElement getSousesLink() {
        return sousesLink;
    }

    public void clickSousesLink() {
        sousesLink.$("span").click();
    }

    public SelenideElement getFillingsLink() {
        return fillingsLink;
    }

    public void clickFillingsLink() {
        fillingsLink.$("span").click();
    }

    public void assertThatThisIsMainPage() {
        $(".BurgerIngredients_ingredients__1N8v2").shouldBe(visible);
    }

}
