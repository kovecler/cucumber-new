package hooks;


import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
    Hooks: her bir Scenario veya Scenarion Outline'den sonra calismasini istegimi methodlar konur
    Before ve After methodlarini icerir. Onemli olan raporlama islemiin ekran goruntusu ile birlikte
    Hook yardimiyla yapilmasidir.
    @Before methodunu Cucumber'den import edecegim
        */


    @Before
    public void setUpScenarios() {
        System.out.println("Before Methodu");
    }

    @After
    public void tearDownScenarios(Scenario scenario) {
        System.out.println("After Methodu");
        //Eger bir Scenario FAIL EDERSE ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());
            Driver.closeDriver();
    //failedScreenshot: ekran goruntusu
            //image/png : file tipi
    //failed_scenario_"+scenario.getName(): Ekran goruntusunun adi
        }


    }


}
