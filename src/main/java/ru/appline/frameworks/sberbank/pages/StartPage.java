package ru.appline.frameworks.sberbank.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//li[@class='kitt-top-menu__item kitt-top-menu__item_first']/label")
    private List<WebElement> listTopMenu;

    @FindBy(xpath = "//li[contains(@class, 'kitt-top-menu__item_opened')]//li")
    private List<WebElement> listSubMenu;

    @FindBy(xpath = "//div[@class = 'kitt-cookie-warning__content']/button[contains(text(), 'Закрыть')]")
    private WebElement closeCookies;

    @Step("Переход в меню {nameMenu}")
    public StartPage selectMenu(String nameMenu){
        elementToBeVisible(listTopMenu.get(0));
        for (WebElement menuElement : listTopMenu){
            if (menuElement.getText().equalsIgnoreCase(nameMenu)) {
                action.moveToElement(menuElement).build().perform();
                elementToBeVisible(menuElement).click();
                return this;
            }
        }
        Assert.fail("Меню '" + nameMenu + "' не было найдено на стартовой странице!");
        return this;
    }

    @Step("Переход в подменю {nameSubMenu}")
    public CompleteHomePage selectSubMenu(String nameSubMenu){
        elementToBeVisible(listSubMenu.get(0));
        for (WebElement subMenuElement : listSubMenu){
            if (subMenuElement.getText().equalsIgnoreCase(nameSubMenu)){
                action.click(subMenuElement);
                elementToBeVisible(subMenuElement).click();
                return app.getCompleteHomePage();
            }
        }
        Assert.fail("Подменю '" + nameSubMenu + "' не было найдено на стартовой странице!");
        return app.getCompleteHomePage();
    }

    @Step("Закрытие окна с куками")
    public StartPage closeCookies(){
        elementToBeVisible(closeCookies);
        closeCookies.click();
        return this;
    }

}
