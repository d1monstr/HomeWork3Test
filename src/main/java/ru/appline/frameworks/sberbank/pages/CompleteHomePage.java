package ru.appline.frameworks.sberbank.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.appline.frameworks.sberbank.managers.DriverManager.getDriver;

public class CompleteHomePage extends BasePage {

    @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input")
    private WebElement costHomeInput;

    @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    private WebElement initFeeInput;

    @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    private WebElement creditDateinput;

    @FindBy(xpath = "//h2[contains(text(), 'Рассчитайте ипотеку')]")
    private WebElement scrollField;

    @FindBy(xpath = "//span[contains(text(), 'Есть зарплатная карта Сбербанка')]/..//input")
    private WebElement checkboxSalaryCard;

    @FindBy(xpath = "//span[contains(text(), 'Использовать материнский капитал')]/..//input")
    private WebElement checkboxMatCapital;

    @FindBy(xpath = "//span[contains(text(), 'Скидка 0,3% при покупке квартиры на ДомКлик')]/../..//input")
    private WebElement checkboxDiscount;

    @FindBy(xpath = "//span[contains(text(), 'Страхование жизни')]/../..//input")
    private WebElement checkboxLifeInsurance;

    @FindBy(xpath = "//span[contains(text(), 'Молодая семья')]/../..//input")
    private WebElement checkboxYoungFamily;

    @FindBy(xpath = "//span[contains(text(), 'Электронная регистрация сделки')]/../..//input")
    private WebElement checkboxElReg;

    @FindBy(xpath = "//span[contains(text(), 'Есть возможность подтвердить доход справкой')]/..//input")
    private WebElement checkboxIncomeStat;

    @FindBy(xpath = "//iframe[@id = 'iFrameResizer0']")
    private WebElement iFrameElement;

    @FindBy(xpath = "//div[@data-test-id='main-results-block']")
    private WebElement resultBlock;

    @Step("Проверка результата {nameCheckResult} на значение {valueCheckResult}")
    public CompleteHomePage checkResult(String nameCheckResult, String valueCheckResult){
        elementToBeVisible(iFrameElement);
        scrollToElementJs(iFrameElement);
        switchToFrame();
        WebElement element = null;
        switch (nameCheckResult) {
            case "Ежемесячный платеж":
                element = check(nameCheckResult, cleanNumber(valueCheckResult));
                break;
            case "Сумма кредита":
                element = check(nameCheckResult, cleanNumber(valueCheckResult));
                break;
            case "Выгода от снижения ставки":
                element = check(nameCheckResult, cleanNumber(valueCheckResult));
                break;
            case "Процентная ставка":
                element = check(nameCheckResult, cleanNumber(valueCheckResult));
                break;
            case "Необходимый доход":
                element = check(nameCheckResult, cleanNumber(valueCheckResult));
                break;
            default:
                Assert.fail("Чекбокс '" + nameCheckResult + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");
        }
        Assert.assertEquals("Чекбокс '" + nameCheckResult + "' был установлен некорректно",
                cleanNumber(valueCheckResult), cleanNumber(element.getText()));
        getDriver().switchTo().parentFrame();
        return this;
    }

    @Step("Переключение чекбокса {nameCheckbox} на значение {checked}")
    public CompleteHomePage checkboxIs(String nameCheckbox, boolean checked){
        elementToBeVisible(iFrameElement);
        scrollToElementJs(iFrameElement);
        switchToFrame();
        WebElement element = null;
        switch (nameCheckbox) {
            case "Есть зарплатная карта Сбербанка":
                setCheckbox(checkboxSalaryCard, checked);
                element = checkboxSalaryCard;
                break;
            case "Использовать материнский капитал":
                setCheckbox(checkboxMatCapital, checked);
                element = checkboxMatCapital;
                break;
            case "Скидка 0,3% при покупке квартиры на ДомКлик":
                setCheckbox(checkboxDiscount, checked);
                element = checkboxDiscount;
                break;
            case "Страхование жизни":
                setCheckbox(checkboxLifeInsurance, checked);
                element = checkboxLifeInsurance;
                break;
            case "Молодая семья":
                setCheckbox(checkboxYoungFamily, checked);
                element = checkboxYoungFamily;
                break;
            case "Электронная регистрация сделки":
                setCheckbox(checkboxElReg, checked);
                element = checkboxElReg;
                break;
            case "Есть возможность подтвердить доход справкой":
                setCheckbox(checkboxIncomeStat, checked);
                element = checkboxIncomeStat;
                break;
            default:
                Assert.fail("Чекбокс '" + nameCheckbox + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");
        }
        Assert.assertEquals("Чекбокс '" + nameCheckbox + "' был установлен некорректно",
                String.valueOf(checked), element.getAttribute("ariaChecked"));
        getDriver().switchTo().parentFrame();
        return this;
    }

    @Step("Заполнение поля {nameField} значением {value}")
    public CompleteHomePage fillField(String nameField, String value) {
        elementToBeVisible(iFrameElement);
        scrollToElementJs(iFrameElement);
        switchToFrame();
        WebElement element = null;
        switch (nameField) {
            case "Стоимость недвижимости":
                fillInputField(costHomeInput, value);
                element = costHomeInput;
                break;
            case "Первоначальный взнос":
                fillInputField(initFeeInput, value);
                element = initFeeInput;
                break;
            case "Срок кредита":
                fillInputField(creditDateinput, value);
                element = creditDateinput;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Ипотека на готовое жилье'");
        }
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                numbersToWithSpace(value), element.getAttribute("value"));
        getDriver().switchTo().parentFrame();
        return this;
    }



}
