import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.NavigationObject;
import lib.ui.SavedListObject;
import lib.ui.SearchPageObject;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Main;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest extends CoreTestCase {
    public MainPageObject MainPageObject;

    public void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    /*
    Задача: тапнуть по поисковому полю, ввести "DNS", открыть найденную вкладку и сравнить текст
    описания заголовка статьи с ожидаемым.
    */
    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("DNS");
        SearchPageObject.waitForSearchResult("российская торговая сеть по продаже бытовой техники и электроники");
    }
}
