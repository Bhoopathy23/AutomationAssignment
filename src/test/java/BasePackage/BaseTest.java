package BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

   public WebDriver driver;

   @BeforeClass
   public void setup(){
       WebDriverManager.chromedriver().setup();

       driver=new ChromeDriver();

       driver.manage().window().maximize();
       driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");
   }
@AfterClass
    public void tearDown(){
       driver.quit();
}

}
















