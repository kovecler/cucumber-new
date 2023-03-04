package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DataTablesPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class DataTablesDefinitions {

    DataTablesPage dataTablesPage= new DataTablesPage();



    @Given("kullanici {string} gider")
    public void kullanici_gider(String string) {
        Driver.getDriver().get(string);
    }


    @When("kullanici new butonuna tiklar")
    public void kullanici_new_butonuna_tiklar() {
     //dataTablesPage.newButton.click();
        ReusableMethod.waitAndClick(dataTablesPage.newButton,10);
    }



    @When("kullanici first name {string} girer")
    public void kullanici_first_name_girer(String string) {
    //dataTablesPage.firstNameBox.sendKeys(string);
        ReusableMethod.waitAndSendText(dataTablesPage.firstNameBox, string,10);//deger gonderebilmek icin 10 saniyeye kadar bekleyecek
    }




    @When("kullanici last name {string} girer")
    public void kullanici_last_name_girer(String string) {
dataTablesPage.lastNameBox.sendKeys(string);
    }



    @When("kullanici positions {string} girer")
    public void kullanici_positions_girer(String string) {
dataTablesPage.positionBox.sendKeys(string);
    }




    @When("kullanici office {string} girer")
    public void kullanici_office_girer(String string) {
        dataTablesPage.officeBox.sendKeys(string);
    }




    @When("kullanici extension {string} girer")
    public void kullanici_extension_girer(String string) {
        dataTablesPage.extensionBox.sendKeys(string);
    }



    @When("kullanici start_date {string} girer")
    public void kullanici_start_date_girer(String string) {
        dataTablesPage.start_DateBox.sendKeys(string);
    }



    @When("kullanici salary {string} girer")
    public void kullanici_salary_girer(String string) {
        dataTablesPage.salaryBox.sendKeys(string);
    }
    @When("kullanici create buttonuna basar")
    public void kullanici_create_buttonuna_basar() {
        dataTablesPage.createButton.click();
    }



    @When("kullanici firstname ile {string} arar")
    public void kullanici_firstname_ile_arar(String string) {
       ReusableMethod.waitAndSendTextWithDefaultTime(dataTablesPage.searchBox,string);
    }


    @Then("firstnamenin {string} olustugunu dogrular")
    public void firstnamenin_olustugunu_dogrular(String string) {
        ReusableMethod.wait(3);
        Assert.assertTrue(ReusableMethod.waitAndGetText(dataTablesPage.aramaSonucu,5).contains(string));
    }




}
