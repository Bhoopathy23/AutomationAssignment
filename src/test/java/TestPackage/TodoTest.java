package TestPackage;

import BasePackage.BaseTest;
import PagesPackage.TodosPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TodoTest extends BaseTest {

    TodosPage todosPage;
    String[] todoItems = {"Complete the Assignment", "Crack the Interview"};


    @Test //TC = 01 : Verify if the item is added to the list
            public void AddToDo() throws InterruptedException {
         todosPage = new TodosPage(driver);
        todosPage.addtodoItem(todoItems);
        List<String> actualTodos=todosPage.getTodoItemsText();
        for(int i=0;i<todoItems.length;i++){
            Assert.assertEquals(actualTodos.get(i),todoItems[i]);
        }

    }

    @Test(dependsOnMethods = "AddToDo")//TC = 02 : Verify the item is present in Completed List
    public void completeTodo() throws InterruptedException {

        todosPage.addAndCompleteTodo();
        List<String> actualcompletedTodos=todosPage.completedTodoitemsGetText();
        for(int i=0;i<todoItems.length;i++){
            Assert.assertEquals(actualcompletedTodos.get(i),todoItems[i]);
        }
        todosPage.clearcompletedTodo();
    }

    @Test(dependsOnMethods = "completeTodo") //TC = 03 : Verify Add and Clear Todo Functionality
    public void addAndCleartodo() throws InterruptedException {
        todosPage.addAndDeletetodoItem(todoItems);
        List<String>alltodos=todosPage.getTodoItemsText();
        for(int i=0;i<todoItems.length;i++){
            Assert.assertEquals(alltodos.get(i),todoItems[i]);
        }
        todosPage.clearNotCompletedTodos();
    }

    //Test the Sofware Test




}
