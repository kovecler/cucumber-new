package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;



/*
************************* ICINDEKILER *****************
1. waitAndClick (WebElement element, int timeout) ==> (EGER ELEMENTE CLİCK YAPMADA SORUN VARSA BU METHOD BEKLEMEK İCİN SURE YAZARAK KULLANABİLİRİZ)

waitAndClick (WebElement element) ==>  (EGER ELEMENTE CLİCK YAPMADA SORUN VARSA ASAGİDAKİ METHOD BEKLEMEK İCİN SURE YAZMADAN
            YUKARİDA STATİC OLARAK YAZİLAN 5 SANİYEYİ KULLANABİLİRİZ)

waitAndClick (WebElement element, int seconds)  ==> (ELEMENTE TIKLMAK ICIN (CLICK YAPMAK) ICIN VERILEN SURE KADAR BEKLEMEK ICIN)

waitAndSendText (WebElement element, String text, int timeout)  ==> (Eger SendKeys yapmada (deger gondermede) sorun yasiyorsak kendimiz beklemek istedigimiz sureyi belirleyerek
                     //asagidaki methodu kullanabiliriz)

waitAndSendTextWithDefaultTime   ==>  (EGER SENDKEYS YAPMADA (DEGER GONDERMEDE) SORUN YASİYORSAK KENDİMİZ BEKLEMEK İSTEDİGİMİZ
            SUREYİ YUKARİDAKİ STATİC
                 // SUREDEN YARARLANARAK ASAGİDAKİ METHODU KULLANABİLİRİZ)
 waitAndGetText   ==>   (ASAGİDAKİ METHODU TEXT'İ ALMAK İCİN BEKLEMEMİZ GEREKEN DURUMLARDA KULLANİRİZ)

 waitAndSendText(WebElement element, String text, int timeout)   ===> EGER SENDKEYS YAPMADA (DEGER GONDERMEDE) SORUN YASİYORSAK
                    KENDİMİZ BEKLEMEK İSTEDİGİMİZ SUREYİ BELİRLEYEREK ASAGİDAKİ METHODU KULLANABİLİRİZ

waitAndSendTextWithDefaultTime(WebElement element, String text)   ===>   //EGER SENDKEYS YAPMADA (DEGER GONDERMEDE) SORUN YASİYORSAK KENDİMİZ BEKLEMEK İSTEDİGİMİZ SUREYİ YUKARİDAKİ
                       STATİC SUREDEN YARARLANARAK ASAGİDAKİ METHODU KULLANABİLİRİZ

waitAndGetText(WebElement element, int timeout)    ===>  TEXT'İ ALMAK İCİN BEKLEMEMİZ GEREKEN DURUMLARDA KULLANİRİZ

waitForVisibility(WebElement element, int timeToWaitInSec)    ===> STATIC OLARAK VERILEN SUREYI KULLANARAK ELEMENT GORUNUNCEYE
                KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU

waitForVisibility(By locator, int timeout)    ===>  KENDI BELIRLEDIGIMIZ SUREYI KULLANARAK ELEMENT GORUNUNCEYE KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU

waitForClickablility(WebElement element, int timeout)    ===>   KENDI BELIRLEDIGIMIZ SUREYI KULLANARAK ELEMENTE CLICK YAPILINCAYA
                    KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU

waitForPageToLoad(long timeOutInSeconds)    ===> YENI SAYFAYA GECISLERDE SAYFANIN YUKLENMESINI BELIRLEDIGIMIZ SURE KADAR BEKLEMEK ICIN JAVA SCRIPT METHODU

executeJScommand(WebElement element, String command)    ===>  ELEMENTE VERILEN KOMUTU CALISTIRMAK ICIN JAVA SCRIPT METHODU

scrollClickWithJS(WebElement element)    ===> VERILEN ELEMENT GORUNTULENINCEYE KADAR SCROLL ETME VE ELEMENTE CLICK YAPMAK ICIN JAVA SCRIPT METHODU

selectAnItemFromDropdown(WebElement item, String selectableItem)    ===> DROPDOWN MENUSUNDEN OGE SECMEK ICIN METHOD

scrollWithJS(WebElement element)    ===> VERILEN ELEMENT GORUNTULENINCEYE KADAR SCROLL ETMEK ICIN JAVA SCRIPT METHODU

clickWithJS(WebElement element)    ===> VERILEN ELEMENTE CLICK YAPMAK ICIN JAVA SCRIPT METHODU

clickWithJSAsList(List<WebElement> elements)   ===>  LIST SEKLINDE ALINAN ELEMENTLERIN HEPSINE CLICK YAPMAK ICIN JAVA SCRIPT METHODU

doubleClickWithActions(WebElement element)   ===>  VERILEN ELEMENTE ACTIONS CLASS KULLANILARAK DOUBLE CLICK METHODU

selectByVisibleText(WebElement element, String text)   ===>   DROPDOWN MENUSUNDEN SELECTBY VISIBLE TEXT ILE SECIM YAPMAK

selectByIndex(WebElement element, int index)   ===>  DROPDOWN MENUSUNDEN  VERILEN INDEX SELECTBY INDEX ILE SECIM YAPMAK

selectByValue(WebElement element, String value)   ===>   DROPDOWN MENUSUNDEN  VERILEN VALUE DEGERI KULLANILARAK  SELECTBY VALUE ILE SECIM YAPMAK VE BUTUN SECENEKLERIN SAYISINI BULMAK ICIN

waitAndClickLocationText(WebElement element, String value)   ===>  TEXT VALUESI VERILEN ELEMENTE CLICK YAPMAK ICIN

switchToWindowWithSekme(int sekmeNumarasi)    ===> SEKME NUMARASI VERILEREK PENCERELER ARASI GECIS YAPMAK ICIN

selectFromDropdown(WebElement dropdown, String secenek)    ===> DROP DOWN MENUSUNDE ISTEDIGIMIZ OGEYE TIKLAMAK ICIN

clickOutside()    ===> TAM SAYFA ACLIR REKLAM KAPATMAK ICIN

kayanReklamiKapat()   ===>  Sayfanın altından kayan reklamı kapatmak için oluşturulan method

rightClickOnElementActions(WebElement element)    ===> ACTIONS_RIGHT CLICK

scrollDownActions()    ===> ACTIONS_SCROLL_DOWN

scrollUpActions()    ===> ACTIONS_SCROLL_UP

scrollRightActions()    ===> ACTIONS_SCROLL_RIGHT

scrollLeftActions()    ===> ACTIONS_SCROLL_LEFT

dragAndDropActions(WebElement source, WebElement target)   ===>  ACTIONS_DRAG_AND_DROP

dragAndDropActions(WebElement source, int x, int y)    ===> ACTIONS_DRAG_AND_DROP_BY

takeScreenShotOfPage(String fileName)   ===>   DOSYA ADI VERILEREK EKRAN GORUNTUSU ALMA

takeScreenshotOfElement(WebElement element)   ===>  VERILEN ELEMENTIN EKRAN GORUNTUSUNU ALMA

webTableDataPrint(String tableNumber, String rowNumber, String columnNumber)   ===>   WEBTABLE'DEN DATA CEKMEK

crollEndJS()    ===>  JAVA SCRIPT ILE SAYFANIN EN ALTINA IN BU method ile sayfanin en altina inebiliriz

scrollTopJS()    ===>  JAVA SCRIPT ILE  SAYFANIN EN USTUNE CIK. Bu method ile sayfanin en ustune cikabiliriz

typeWithJS( String metin, WebElement element)    ===>  girmis oldugum metni elemente yazdirir bu method sendKeys metotuna bir alternatifdir.

getValueByJS(String idOfElement)    ===>   JAVA SCRIPT ILE   input elementindeki degerleri(value) al

basicAuthentication(String url, String adminName, String password)     ===>  Basic Authentication ALERT SEKLINDE YUKARIDAN ACILAN PENCERELERE KULLANICI ADI VE PASSWORD YAZDIRABILMEK ICIN

 */
public class Driver {
    //create a driver instance
    private static WebDriver driver;
    private static int timeout = 5;

    //What?=>It is just to create, initialize the driver instance.(Singleton driver)
    //Why?=>We don't want to create and initialize the driver when we don't need
    //We will create and initialize the driver when it is null
    //We can use Driver class with different browser(chrome,firefox,headless)
    private Driver() {
        //we don't want to create another abject. Singleton pattern
    }

    //to initialize the driver we create a static method
    public static WebDriver getDriver() {
        //create the driver if and only if it is null
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("edge".equals(browser)) {
                WebDriverManager.edgedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("safari".equals(browser)) {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
            } else if ("chrome-headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver = null;//set it back to null to make sure driver is null
            // so I can initialize it again
            //This is important especially you do cross browser testing(testing with
            // multiple browser like chrome, firefox, ie etc.)
        }
    }
}