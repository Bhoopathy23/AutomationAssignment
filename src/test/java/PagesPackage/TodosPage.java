package PagesPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TodosPage {

    public WebDriver driver;

    public TodosPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".new-todo")
    private WebElement todoTxtField;

    @FindBy(css = ".toggle")
    private String todoCheckBox=".toggle";

    @FindBy(xpath = "//a[@routerlink='/completed']")
    private WebElement CompletedBtn;

    @FindBy(xpath = "//a[@routerlink='/active']")
    private WebElement ActiveBtn;

    @FindBy(css = ".selected")
    private WebElement allbtn;

    @FindBy(xpath = "//input[@class='toggle']/following-sibling::label")
    private WebElement todoData;

    @FindBy(css = ".clear-completed")
    private WebElement ClearCompletedBtn;

    @FindBy(css = ".destroy")
    private List<WebElement> webElementclearBtn;

    private String clearBtn= ".destroy";

    @FindBy(xpath = "//li[@class='completed']//label")
    private List<WebElement> todoCompletedData;

    @FindBy(xpath = "//ul[@class='todo-list']//label")
    private WebElement todoItemsList;

    @FindBy(xpath = "//div[@class='view']/label")
    private List<WebElement> todoDataBeforeCheck;

    public void addtodoItem(String[] todoItems) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(todoTxtField));

        for(int i=0;i<todoItems.length;i++){
            todoTxtField.sendKeys(todoItems[i]);
            todoTxtField.sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);
    }


    public List<String> getTodoItemsText(){
        List<String> actualItems = new ArrayList<>();
        for(WebElement items:todoDataBeforeCheck){
            actualItems.add(items.getText());
        }
        return actualItems;
    }

    public void addAndCompleteTodo() throws InterruptedException {
        List<WebElement> allCheckboxes =driver.findElements(By.cssSelector(todoCheckBox));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for(WebElement checkbox:allCheckboxes){
            js.executeScript("arguments[0].click();",checkbox);
        }
        Thread.sleep(5000);
        CompletedBtn.click();
    }
    public void clearcompletedTodo() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        for(WebElement btnClear : webElementclearBtn){
            actions.moveToElement(todoData).click(btnClear).perform();
        }
        Thread.sleep(5000);
    }

    public List<String> completedTodoitemsGetText(){
        List<String> allCompletedTodos=new ArrayList<>();
        for(WebElement completedTodo:todoCompletedData){
            allCompletedTodos.add(completedTodo.getText());
        }
        return allCompletedTodos;
    }

    public void addAndDeletetodoItem(String[] todoItems) throws InterruptedException {
        for(int i=0;i<todoItems.length;i++){
            todoTxtField.sendKeys(todoItems[i]);
            todoTxtField.sendKeys(Keys.ENTER);
        }
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ActiveBtn));
        ActiveBtn.click();
        Thread.sleep(5000);

    }
    public void clearNotCompletedTodos(){
        Actions actions = new Actions(driver);
        for(WebElement ClearBtn:webElementclearBtn){
            actions.moveToElement(todoData).click(ClearBtn).perform();
        }
    }



    public void clickActiveBtn() {


    }

}


