package InsiderTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    // Define driver
  protected WebDriver driver;
  //Define assertion
  protected  SoftAssert softAssert;


  @BeforeMethod()
    public void setup(){
        //Driver config
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();
    }





    @AfterMethod
    public void tearDown(){
        //Quit driver and made driver null
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
