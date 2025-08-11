package InsiderTests;
import PomPages.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InsiderTests extends BaseTest {

    private InsiderMainPage insiderMainPage;
    private CareersDetailPage careersDetailPage;
    private QACareerDetailsPage qaCareerDetailsPage;
    private FindJobsPage findJobsPage;

    @BeforeMethod
    public void setupClasses(){
        insiderMainPage = new InsiderMainPage(driver);
        careersDetailPage = new CareersDetailPage(driver);
        qaCareerDetailsPage = new QACareerDetailsPage(driver);
        findJobsPage = new FindJobsPage(driver);
    }


    @Test(priority = 1,enabled = true,alwaysRun = false)
    public void checkInsiderMainPageVisibilityAndVerifyLocationTeamsAndLifeAtInsiderSections(){
        //Navigate main page of insider
        insiderMainPage.NavigateMainPageOfInsider();


     WebElement visibilityOfCareerSubsection= insiderMainPage.verifyCareersSubSectionDisplayedOnUsersPage();

        //Assertion for career subsection
        softAssert.assertTrue(visibilityOfCareerSubsection.isEnabled());

        //Navigate career details page
        insiderMainPage.navigateCareersPage();




        //Assertion for team section, location title and life at Insider title visibility
        softAssert.assertTrue(careersDetailPage.checkTeamsSectionVisibility().isDisplayed());
        softAssert.assertTrue(careersDetailPage.checkLocationSectionVisibility().isDisplayed());
        softAssert.assertTrue(careersDetailPage.checkVisibilityOfLifeAtInsiderTitle().isDisplayed());


        //Life at insider detailed message, and also location details message text
        softAssert.assertTrue(careersDetailPage.getTextOfTheLocationInfo().contains("28 offices across 6 continents, home to 1100+ Insiders"));
        softAssert.assertEquals(careersDetailPage.getTextOfLifAtInsiderDiscussMessage().length(),272);
        softAssert.assertTrue(careersDetailPage.getTextOfLifAtInsiderDiscussMessage().toLowerCase().contains("we’re here to grow and drive growth—as none of us did before."));
        softAssert.assertTrue(careersDetailPage.getTextOfLifAtInsiderDiscussMessage().toUpperCase().contains("WE’RE HERE TO GROW AND DRİVE GROWTH—AS NONE OF US DİD BEFORE."));
        softAssert.assertAll("All tests are asserted");
    }


    @Test(priority = 2,enabled = true,alwaysRun = false,dependsOnMethods = "checkInsiderMainPageVisibilityAndVerifyLocationTeamsAndLifeAtInsiderSections")
    public void checkJobsViewPageAndSelectedJobDetails(){
        //Navigation QA Career page
        qaCareerDetailsPage.NavigateQaJobsPageOfInsider();

        //Assertion for QA Title Visibility
        softAssert.assertTrue(qaCareerDetailsPage.checkQATitleVisibility().isDisplayed());

        //Navigate Job opportunities page
        qaCareerDetailsPage.navigateFindJobsPage();

        //Select location and career path
        findJobsPage.selectLocationAndDepartment();

        //Log for texts
        System.out.println(findJobsPage.getTextOfSelectedLocation());
        System.out.println(findJobsPage.getTextOfSelectedJobTitle());

        //Assertion for dropDownList Texts
        softAssert.assertEquals(findJobsPage.getTextOfSelectedLocation(),"×\n" + "Istanbul, Turkiye");
        softAssert.assertEquals(findJobsPage.getTextOfSelectedJobTitle(),"×\n" + "Quality Assurance");

        //Navigate Job Details Page
        findJobsPage.navigateJobDetailsPage();

       //Assertion for job title text
        softAssert.assertEquals(findJobsPage.getJobTitleText(),"Software Quality Assurance Engineer");
        softAssert.assertAll("All tests are asserted");

    }
}
