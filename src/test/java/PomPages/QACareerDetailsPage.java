package PomPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QACareerDetailsPage extends BasePage{

    @FindBy(css = "a[href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    private WebElement seeAllJobsButton;

    @FindBy(xpath = "//h1[contains(text(),'Quality Assurance')]")
    private WebElement QaTitle;

    @FindBy(id = "wt-cli-reject-btn")
    private WebElement cookiesId;

    public QACareerDetailsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void navigateFindJobsPage(){
        cookiesId.click();
        seeAllJobsButton.click();
    }

    public WebElement checkQATitleVisibility(){
        WebElement title = QaTitle;
        return title;
    }



}
