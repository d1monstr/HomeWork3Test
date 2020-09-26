package ru.appline.sberbank.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.frameworks.sberbank.managers.InitManager;
import ru.appline.frameworks.sberbank.managers.ManagerPages;
import ru.appline.frameworks.sberbank.managers.TestPropManager;

import static ru.appline.frameworks.sberbank.managers.DriverManager.getDriver;
import static ru.appline.frameworks.sberbank.utils.PropConst.APP_URL;

public class BaseTests {

    protected ManagerPages app = ManagerPages.getManagerPages();

    @BeforeClass
    public static void before() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach(){
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));

    }

    @AfterClass
    public static void after() {

        InitManager.quitFramework();
    }
}
