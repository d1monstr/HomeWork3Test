package ru.appline.sberbank.tests;

import org.junit.Test;
import ru.appline.sberbank.base.BaseTests;

public class SecondTest extends BaseTests {

    @Test
    public void test() {

        app.getStartPage()
                .closeCookies()
                .selectMenu("Ипотека")
                .selectSubMenu("Ипотека на готовое жильё")
                .fillField("Стоимость недвижимости", "5180000")
                .fillField("Первоначальный взнос", "3058000")
                .fillField("Срок кредита", "30")
                .checkboxIs("Есть зарплатная карта Сбербанка", false)
                .checkboxIs("Молодая семья", true)
                .checkResult("Сумма кредита", "2 122 000")
                .checkResult("Ежемесячный платеж", "15 276")
                .checkResult("Необходимый доход", "19 665")
                .checkResult("Процентная ставка", "7,8");

    }

}
