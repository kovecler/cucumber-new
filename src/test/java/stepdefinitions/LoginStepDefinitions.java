package stepdefinitions;

import io.cucumber.java.en.When;
import pages.BlueRentalLoginPage;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {
    @When("kullanici emaili ve sifresini girer")
    public void kullaniciEmailiVeSifresiniGirer(io.cucumber.datatable.DataTable dataTable) {
        BlueRentalLoginPage blueRentalLoginPage= new BlueRentalLoginPage();
////List<String> olarak datalari depolayabiliriz
//       List<String> musteriBilgisi= dataTable.row(1);
//        System.out.println(musteriBilgisi.get(0)); //email
//        System.out.println(musteriBilgisi.get(1)); //password
//        blueRentalLoginPage.emailBox.sendKeys(musteriBilgisi.get(0));
//        blueRentalLoginPage.passwordBox.sendKeys(musteriBilgisi.get(1));
//        blueRentalLoginPage.loginButton.click();
//2. DataTable da datalari List<Map<String, String>> de depolayabiliriz
        List<Map<String, String>> musteriBilgisi= dataTable.asMaps(String.class, String.class);
        for (Map<String, String>musteri : musteriBilgisi){
            blueRentalLoginPage.emailBox.sendKeys(musteri.get("email"));
            blueRentalLoginPage.passwordBox.sendKeys(musteri.get("sifre"));
            blueRentalLoginPage.loginButton.click();
        }
    }
}
