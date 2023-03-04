package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //raporlarin consolda olusmasini saglar
                "html:target/cucumber-reports/html-reports/default-cucumber-reports.html",
                "json:target/cucumber-reports/json-reports/cucumber.json",
                "junit:target/cucumber-reports/xml-report/cucumber.xml"
        },
        monochrome=true, //consolda test steplerinin aciklamali sekilde verilmesi icin

        features = "./src/test/resources/features",//features folder path
        glue = {"stepdefinitions", "hooks"},   //stepdefinitions path
        tags = "@excel_automation",
        dryRun = false

)
public class Runner {
}
//Bu sinif Test caseleri RUN etmek icin kullanilir
//Ve konfigurasyonlar icin kullanilir
//Runner class, features file lar ile step defitions i birbirile baglar