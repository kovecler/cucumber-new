package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Allure2youPage {

    public Allure2youPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccount;

    @FindBy(id = "username")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement sifreBox;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Account details']")
    public WebElement accountDetails;

    @FindBy(id = "account_first_name")
    public WebElement first_name;

    @FindBy(id = "account_last_name")
    public WebElement last_name;

    @FindBy(id = "account_display_name")
    public WebElement display_name;

    @FindBy(id = "account_email")
    public WebElement email;
}