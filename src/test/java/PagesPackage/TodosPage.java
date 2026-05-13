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

public class TodosPage {

    public WebDriver driver;

    String todoitem ="Complete the Assignment";
    String todoitem2 ="Crack the Interview";
    public TodosPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".new-todo")
    private WebElement todoTxtField;

    @FindBy(css = ".toggle")
    private WebElement todoCheckBox;

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
    private WebElement clearBtn;

    @FindBy(xpath = "//li[@class='completed']//label")
    private WebElement todoCompletedData;

    @FindBy(xpath = "//ul[@class='todo-list']//label")
    private WebElement todoItemsList;

    public void addtodoItem() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(todoTxtField));
        todoTxtField.sendKeys(todoitem);
        todoTxtField.sendKeys(Keys.ENTER);
        Assert.assertEquals(todoData.getText(), todoitem);
    }

    public void addAndCompleteTodo() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",todoCheckBox);
        CompletedBtn.click();
        Assert.assertEquals(todoCompletedData.getText(),todoitem);
        Actions actions = new Actions(driver);
        actions.moveToElement(todoData).click(clearBtn).perform();
    }

    public void addAndDeletetodoItem() {
        todoTxtField.sendKeys(todoitem);
        todoTxtField.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.moveToElement(todoData).click(clearBtn).perform();
       String todoitemcheck =todoItemsList.getText();
       Assert.assertEquals(todoitemcheck,todoitem);
    }



//    public void allTodoCheck() {
//
//    }
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(ActiveBtn));
//        ActiveBtn.click();
//
//      CompletedBtn.click();
//
//        Assert.assertEquals(todoData.getText(),todoitem);
//        ClearCompletedBtn.click();
//
//    }

}

//input[@class='toggle']/following-sibling::label - todo text
//.new-todo - textbox
//a[@routerlink='/completed']
//.selected
//a[@routerlink='/active']
//.toggle - Checkbox todo
