package Helpers.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitersPage {

    public RecruitersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=ri-header__title]")
    protected WebElement pageTitle;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public String pageTitleText(){
        return getPageTitle().getText();
    }
}
