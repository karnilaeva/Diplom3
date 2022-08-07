package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

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

    // локатор контейнера
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__1N8v2")
    private SelenideElement container;

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
        bunsLink.click();
    }

    public SelenideElement getSousesLink() {
        return sousesLink;
    }

    public void clickSousesLink() {
        sousesLink.click();
    }

    public SelenideElement getFillingsLink() {
        return fillingsLink;
    }

    public void clickFillingsLink() {
        fillingsLink.click();
    }

    public void assertThatThisIsMainPage() {
        container.shouldBe(visible);
    }

}
