package ru.yandex.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    // локатор ссылки "Конструктор"
    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'AppHeader_header__link__3D_hX')]")
    private SelenideElement constructorLink;

    // локатор логотипа
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    // локатор ссылки "Выход"
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logoutLink;

    public void clickConstructorLink() {
        constructorLink.click();
    }

    public void assertThatThisIsAccountPage() {
        $(".Account_account__vgk_w").shouldBe(visible);
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }
}