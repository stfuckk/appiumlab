import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.NavigationObject;
import lib.ui.SavedListObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class SecondTest extends CoreTestCase {
    public MainPageObject MainPageObject;

    public void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    /*
    Задача: тапнуть по поисковому полю, ввести "Хоббит, или Туда и обратно", перейти в статью,
    Нажать на кнопку-икону с надписью "Сохранить". Добавить в список, затем выйти на домашнюю страницу,
    перейти в раздел сохраненных, удалить список.
    */

    @Test
    public void testHobbit() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        NavigationObject NavigationObject = new NavigationObject(driver);

        SearchPageObject.initSearchInput();
        // на английском языке вводим, потому что сбивается кодировка и вводятся непонятные символы
        SearchPageObject.typeSearchLine("The Hobbit, or there and back again");
        SearchPageObject.clickOnSearchResult("повесть английского писателя Джона Р. Р. Толкина");

        SavedListObject savedListObject = new SavedListObject(driver);
        String listTitle = "Hobbit";

        savedListObject.addToList(listTitle);

        NavigationObject.back();
        NavigationObject.back();

        savedListObject.openLists();

        Assert.assertTrue("List is present", savedListObject.isListPresent(listTitle));

        savedListObject.openList(listTitle);
        savedListObject.deleteList();

        Assert.assertFalse("List is not present", savedListObject.isListPresent(listTitle));
    }
}