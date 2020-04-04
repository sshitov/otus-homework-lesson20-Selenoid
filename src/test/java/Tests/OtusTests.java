package Tests;

import Helpers.Pages.CoursesPage;
import Helpers.Pages.MainPage;
import Helpers.Pages.RecruitersPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class OtusTests extends BaseTest{

    private MainPage mainPage;
    private RecruitersPage recruitersPage;
    private CoursesPage coursesPage;

    @Before
    public void setUp() throws MalformedURLException {
        create();
        mainPage = new MainPage(getDriver());
        recruitersPage = new RecruitersPage(getDriver());
        coursesPage = new CoursesPage(getDriver());
        mainPage.openMainPage();
    }

    @After
    public void tearDown() {
        quit();
    }


    @Test
    public void openBlogPage() {

        mainPage.navigateToBlogPage();
        Assert.assertEquals("https://otus.ru/nest/posts/", currentUrl());
    }

    @Test
    public void openCoursesPageFilteredByTesting() {

        mainPage.navigateToCoursesPageFilteredByTesting();
        Assert.assertEquals("Тестирование", coursesPage.courseCategoryName());
    }

    @Test
    public void openFacebookPage() {

        mainPage.navigateToFacebookPage();
        selectBrowserTab(1);
        Assert.assertEquals("https://www.facebook.com/otusru/", currentUrl());
    }

    @Test
    public void openRecruiterPage() {

        mainPage.navigateToRecruiterPage();
        Assert.assertEquals("IT-Recruiter", recruitersPage.pageTitleText());
    }

    @Test
    public void openTermsOfUsePage() {

        mainPage.navigateToTermsOfUsePage();
        Assert.assertEquals("https://otus.ru/legal/terms/", currentUrl());
    }

    @Test
    public void subscribeToNewsNotifications() {

        mainPage.fillTheSubscribeField("example@example.ru");
        mainPage.submitSubscribeForm();
        Assert.assertTrue(mainPage.successSubscribeMessageIsPresent());
    }
}
