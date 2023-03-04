package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.Driver;

public class GoogleStepDefinitions_Parametreli {
    GooglePage googlePage = new GooglePage();


    @When("kullanici {string} icin arama yapar")
    public void kullanici_icin_arama_yapar(String string) {
        googlePage.searchBox.sendKeys(string  + Keys.ENTER);

    }


    @Then("sonuclarin {string} icerdigini dogrula")
    public void sonuclarda_oldugunu_dogrular(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }


}
