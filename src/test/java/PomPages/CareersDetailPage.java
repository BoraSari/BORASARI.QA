package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;

public class CareersDetailPage extends BasePage{
    @FindBy(xpath = "//div//h3[@class='category-title-media'][1]")
    private WebElement teamsSectionTitle;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    private WebElement locationsTitle;

    @FindBy(xpath ="//p[contains(text(),'28 offices across 6 continents, home to 1100+ Insiders')]" )
    private WebElement locationInfoText;

    @FindBy(xpath = "//h2[contains(text(),'Life at Insider')]")
    private  WebElement lifeAtInsiderTile;

    @FindBy(xpath = "//p[contains(text(),'We’re here to grow and drive growth—as none of us did before. Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. We know that we’re smarter as a group than we are alone. Become one of us if you dare to play bigger.')]")
    private  WebElement LifeAtInsiderDiscussMessage;

    public CareersDetailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public WebElement checkTeamsSectionVisibility(){
        getExecutorClass().executeScript("arguments[0].scrollIntoView();",teamsSectionTitle);
        WebElement teams = teamsSectionTitle;
        return  teams;
    }


    public WebElement checkLocationSectionVisibility(){
        getExecutorClass().executeScript("arguments[0].scrollIntoView();",locationsTitle);
        WebElement location = locationsTitle;
        return location;
    }

    public String  getTextOfTheLocationInfo(){
        String info = locationInfoText.getText();
        return info;
    }


    public WebElement checkVisibilityOfLifeAtInsiderTitle(){
        getExecutorClass().executeScript("arguments[0].scrollIntoView();",lifeAtInsiderTile);
        WebElement title = lifeAtInsiderTile;
        return title;
    }

    public String getTextOfLifAtInsiderDiscussMessage(){
        String message = LifeAtInsiderDiscussMessage.getText();
        return message;
    }




}
