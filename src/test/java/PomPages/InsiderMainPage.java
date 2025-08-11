package PomPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsiderMainPage extends BasePage{

    @FindBy(xpath = "(//a[@class='nav-link dropdown-toggle hide-after'])[5]")
    private WebElement companyNavigationBarSection;


    @FindBy(xpath = "(//a[@class='dropdown-sub'])[21]")
    private  WebElement careersSubSection;


    public InsiderMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }



    public void navigateCareersPage(){
        getActionsClass().moveToElement(companyNavigationBarSection).build().perform();
        if (careersSubSection.isDisplayed()){
            careersSubSection.click();
        }

    }


    public WebElement verifyCareersSubSectionDisplayedOnUsersPage(){
        return careersSubSection;
    }


}
