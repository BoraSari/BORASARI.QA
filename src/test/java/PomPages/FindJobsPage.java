package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FindJobsPage extends BasePage{

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement dropDownListBoxForLocation;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement dropDownListBoxForDepartment;

    @FindBy(id = "filter-by-location")
    private WebElement locationSelectDropDownList;


    @FindBy(id = "filter-by-department")
    private WebElement departmentSelectDropDownList;


    @FindBy(css = "span[title='Istanbul, Turkiye']")
    private WebElement selectedLocation;

    @FindBy(css = "span[title='Quality Assurance']")
    private WebElement selectedJobTitle;

    @FindBy(css = "a[href='https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757']")
    private WebElement viewJobDetailsButton;

    @FindBy(xpath = "//h2[contains(text(),'Software Quality Assurance Engineer')]")
    private WebElement qaJobTitle;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[2]")
    private WebElement selectedJobCoverSection;

   @FindBy(id = "select2-filter-by-location-result-yftb-Istanbul, Turkiye")
   private WebElement city;


   @FindBy(xpath = "//span[@class='select2-selection__arrow'][1]")
   private WebElement locationDropDownListArrow;



    public FindJobsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void selectLocationAndDepartment(){

        Select location = new Select(locationSelectDropDownList);
        Select department = new Select(departmentSelectDropDownList);
        dropDownListBoxForDepartment.click();
        getExplictWaitClass().until(ExpectedConditions.visibilityOfElementLocated(By.id("filter-by-department")));
        department.selectByVisibleText("Quality Assurance");
        dropDownListBoxForLocation.click();
        location.selectByContainsVisibleText("Istanbul, Turkiye");
    }

    public String getTextOfSelectedLocation(){
        String locationText = selectedLocation.getText();
        return locationText;
    }

    public String getTextOfSelectedJobTitle(){
        String jobText = selectedJobTitle.getText();
        return jobText;
    }


    public void navigateJobDetailsPage(){
        getExecutorClass().executeScript("arguments[0].scrollIntoView();",selectedJobCoverSection);
        getActionsClass().moveToElement(selectedJobCoverSection).build().perform();
      viewJobDetailsButton.click();


    }

    public String getJobTitleText(){
        Object[] navigateNewPage = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) navigateNewPage[1]);
        String title = qaJobTitle.getText();
        return  title;
    }


}
