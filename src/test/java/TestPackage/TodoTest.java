package TestPackage;

import BasePackage.BaseTest;
import PagesPackage.TodosPage;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    TodosPage todosPage;

    @Test //TC = 01 : Verify if the item is added to the list
            public void AddToDo(){
         todosPage = new TodosPage(driver);
        todosPage.addtodoItem();

    }

    @Test(dependsOnMethods = "AddToDo")
    public void completeTodo(){
        todosPage.addAndCompleteTodo();
    }

}
