package PomPages;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    //Define Driver in Base Page
protected  WebDriver driver;

//Define Required Urls
protected  String mainPageUrl = "https://useinsider.com/";
protected  String qaCareerPageUrl = "https://useinsider.com/careers/quality-assurance/";

    protected  BasePage(WebDriver driver){
        this.driver = driver;
    }


    protected Actions getActionsClass(){
        Actions actions = new Actions(driver);
        return  actions;
    }


  protected WebDriverWait getExplictWaitClass(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.ignoring(ElementNotInteractableException.class);
        wait.ignoring(ElementClickInterceptedException.class);
        return  wait;
  }

  protected JavascriptExecutor getExecutorClass(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return  js;
  }

  public void NavigateMainPageOfInsider(){
        driver.get(mainPageUrl);
  }


 public void NavigateQaJobsPageOfInsider(){
        driver.get(qaCareerPageUrl);
    }

}
