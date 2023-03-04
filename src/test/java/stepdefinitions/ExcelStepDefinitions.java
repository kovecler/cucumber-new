package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {

    //page objelerini olustur
BlueRentalHomePage blueRentalHomePage= new BlueRentalHomePage();
BlueRentalLoginPage blueRentalLoginPage= new BlueRentalLoginPage();
ExcelUtils excelUtils;
List<Map<String, String>> excelDatalari;

    @Given("kullanici {string} bilgileri ile giris yapar")
    public void kullanici_bilgileri_ile_giris_yapar(String string) throws IOException {
        String path="src/test/resources/testdata/mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils=new ExcelUtils(path,sayfa);
        excelDatalari=excelUtils.getDataList();


        //        home page logine tikla
        for (Map<String,String> data:excelDatalari) {
            //        Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            blueRentalHomePage= new BlueRentalHomePage();
            blueRentalLoginPage = new BlueRentalLoginPage();
            blueRentalHomePage.loginLink.click();
            ReusableMethod.wait(1);// 1 saniye bekle
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethod.wait(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethod.wait(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethod.wait(1);
            //Girislerden sonra dogrulama islemi icin
            ReusableMethod.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethod.wait(1);
            //herbir giristen sonra ekran goruntusu almak icin
            ReusableMethod.getScreenshot("Ekran Goruntusu");
            blueRentalHomePage.userID.click();
            ReusableMethod.wait(1);
            blueRentalHomePage.logOutLink.click();
            ReusableMethod.wait(1);
            blueRentalHomePage.OK.click();
        }
        Driver.closeDriver();
    }
    }

