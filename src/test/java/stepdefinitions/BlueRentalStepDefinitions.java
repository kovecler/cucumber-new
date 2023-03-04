package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;


public class BlueRentalStepDefinitions {

    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();


    @When("kullanici login sayfasina gider")
    public void kullanici_login_sayfasina_gider() {
        blueRentalHomePage.loginLink.click();
    }

    @When("kullanici adini {string} girer")
    public void kullanici_adini_girer(String string) {
blueRentalLoginPage.emailBox.sendKeys(string);
    }

    @When("kullanici sifreyi {string} girer")
    public void kullanici_sifreyi_girer(String string) {
        blueRentalLoginPage.passwordBox.sendKeys(string);
    }

    @When("kullanici login buttoning basar")
    public void kullanici_login_buttoning_basar() {
        blueRentalLoginPage.loginButton.click();
    }

    @Then("login islemi gerceklesir")
    public void login_islemi_gerceklesir() {
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());

    }
}
