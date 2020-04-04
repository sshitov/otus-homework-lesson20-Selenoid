package Helpers.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    protected String baseUrl = "https://otus.ru/";

    @FindBy(css = "[id='categories_id'] [title='Тестирование']")
    protected WebElement testingCoursesLink;

    @FindBy(css = ".header2_subheader-container__right [title='Блог']")
    protected WebElement blogSectionLink;

    @FindBy(css = ".header2_subheader-container__right [title='Рекрутерам']")
    protected WebElement recruiterSectionLink;

    @FindBy(css = "[class='footer2__container container'] [name='email']")
    protected WebElement subscribeEmailField;

    @FindBy(css = "[class='footer2__container container'] button")
    protected WebElement subscribeSubmitButton;

    @FindBy(css = ".subscribe-modal__success")
    protected WebElement successSubscribeMessage;

    public WebElement getRecruiterSectionLink() {
        return recruiterSectionLink;
    }

    public WebElement getSubscribeEmailField() {
        return subscribeEmailField;
    }

    public WebElement getSubscribeSubmitButton() {
        return subscribeSubmitButton;
    }

    public WebElement getSuccessSubscribeMessage() {
        return successSubscribeMessage;
    }

    public WebElement getBlogSectionLink() {
        return blogSectionLink;
    }

    public WebElement getTestingCoursesLink() {
        return testingCoursesLink;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void openMainPage() {
        driver.get(getBaseUrl());
    }

    public void navigateToCoursesPageFilteredByTesting(){
        getTestingCoursesLink().click();
    }

    public void navigateToBlogPage(){
        getBlogSectionLink().click();
    }

    public void navigateToFacebookPage(){
        String script = "document.querySelector(\"[class='footer2__container container'] [class*='fb']\").click();";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    public void navigateToTermsOfUsePage(){
        String script = "document.querySelector(\"[class='footer2__container container'] [href='/legal/terms/']\").click();";
        ((JavascriptExecutor) driver).executeScript(script);
    }

    public void navigateToRecruiterPage(){
        getRecruiterSectionLink().click();
    }

    public void fillTheSubscribeField(String email){
        getSubscribeEmailField().clear();
        getSubscribeEmailField().sendKeys(email);
    }

    public void submitSubscribeForm(){
        getSubscribeSubmitButton().click();
    }

    public boolean successSubscribeMessageIsPresent(){
        return getSuccessSubscribeMessage().isDisplayed();
    }

}
