package Helpers.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesPage {

    public CoursesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".title-new__text h1")
    protected WebElement courseCategoryTitle;

    public WebElement getCourseCategoryTitle() {
        return courseCategoryTitle;
    }

    public String courseCategoryName(){
        return getCourseCategoryTitle().getText();
    }
}
