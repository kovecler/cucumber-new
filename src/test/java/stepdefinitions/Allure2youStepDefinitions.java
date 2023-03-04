package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.Allure2youPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Allure2youStepDefinitions {
    Allure2youPage allure2youPage=new Allure2youPage();

    @Given("Kullanici sayfaya sayfasına gider")
    public void kullaniciSayfayaSayfasınaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("allure2you_Url"));
    }
    @When("Kullanıcı myAccount tiklar.")
    public void kullanıcı_my_account_tiklar() {
        allure2youPage.myAccount.click();

    }
    @When("Kullanici email girer")
    public void kullanıcı_email_girer() {
        allure2youPage.emailBox.sendKeys("yahya_54321@gmail.com");
    }
    @When("Kullanici password girer")
    public void kullanıcı_password_girer() {
        allure2youPage.sifreBox.sendKeys("123456Yahya!'%&");
    }

    @When("kullanici SIGN IN tiklar")
    public void kullanici_sıgn_ın_tiklar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", allure2youPage.loginButton);

    }
    @When("Soldaki Account details butonunu tıklar.")
    public void soldaki_account_details_butonunu_tıklar() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", allure2youPage.accountDetails);
        //   allure2youPage.accountDetails.click();

    }
    @Then("First name bilgilerini görür")
    public void first_name_bilgilerini_görür() {
        Assert.assertTrue(allure2youPage.first_name.isDisplayed() );
    }
    @Then("Last name bilgilerini görür")
    public void last_name_bilgilerini_görür() {
        Assert.assertTrue(allure2youPage.last_name.isDisplayed());
    }
    @Then("Display name bilgilerini görür")
    public void display_name_bilgilerini_görür() {
        Assert.assertTrue(allure2youPage.display_name.isDisplayed());
    }
    @Then("Email address bilgilerini görür.")
    public void email_address_bilgilerini_görür() {
        Assert.assertTrue(allure2youPage.email.isDisplayed());
    }




}