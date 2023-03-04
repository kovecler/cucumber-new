package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethod {

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

    //create a driver instance
    private static WebDriver driver;
    private static int timeout = 5;





    //eger elemente click yapmada sorun varsa asagidaki method beklemek icin sure yazarak kullanabiliriz
    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    //eger elemente click yapmada sorun varsa asagidaki method beklemek icin sure yazmadan yukarida static olarak
    // yazilan 5 saniyeyi kullanabiliriz
    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    //ELEMENTE TIKLMAK ICIN (CLICK YAPMAK) ICINVERILEN SURE KADAR BEKLEMEK ICIN
    public static void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                wait2(1);
            }
        }
    }

    //EGER SENDKEYS YAPMADA (DEGER GONDERMEDE) SORUN YASİYORSAK KENDİMİZ BEKLEMEK İSTEDİGİMİZ SUREYİ BELİRLEYEREK ASAGİDAKİ METHODU KULLANABİLİRİZ
    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    //EGER SENDKEYS YAPMADA (DEGER GONDERMEDE) SORUN YASİYORSAK KENDİMİZ BEKLEMEK İSTEDİGİMİZ SUREYİ YUKARİDAKİ
    // STATİC SUREDEN YARARLANARAK ASAGİDAKİ METHODU KULLANABİLİRİZ

    public static void waitAndSendTextWithDefaultTime(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }


    //ASAGİDAKİ METHODU TEXT'İ ALMAK İCİN BEKLEMEMİZ GEREKEN DURUMLARDA KULLANİRİZ
    public static String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }

    //Webdriver
    //ChromeDriver
    //Iedriver
    //FirefoxDriver
    public static void wait2(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //STATIC OLARAK VERILEN SUREYI KULLANARAK ELEMENT GORUNUNCEYE KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    // KENDI BELIRLEDIGIMIZ SUREYI KULLANARAK ELEMENT GORUNUNCEYE KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    //KENDI BELIRLEDIGIMIZ SUREYI KULLANARAK ELEMENTE CLICK YAPILINCAYA KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //LOCATE BILGILERI VERILEN ELEMENTE CLICK YAPILINCAYA KADAR BEKLEMEK ICIN EXPLICIT WAIT METHODU
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    //SAYFANIN YUKLENMESINI BELIRLEDIGIMIZ SURE KADAR BEKLEMEK ICIN JAVA SCRIPT METHODU
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    //ELEMENTE VERILEN KOMUTU CALISTIRMAK ICIN JAVA SCRIPT METHODU
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }


    //DROPDOWN MENUSUNDEN OGE SECMEK ICIN METHOD
    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }


    //VERILEN ELEMENT GORUNTULENINCEYE KADAR SCROLL ETME VE ELEMENTE CLICK YAPMAK ICIN JAVA SCRIPT METHODU
    public static void scrollClickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    //VERILEN ELEMENTE CLICK YAPMAK ICIN JAVA SCRIPT METHODU
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    //VERILEN ELEMENT GORUNTULENINCEYE KADAR SCROLL ETMEK ICIN JAVA SCRIPT METHODU
    public static void scrollWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //LIST SEKLINDE ALINAN ELEMENTLERIN HEPSINE CLICK YAPMAK ICIN JAVA SCRIPT METHODU
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }

    //VERILEN ELEMENTE ACTIONS CLASS KULLANILARAK DOUBLE CLICK METHODU
    public static void doubleClickWithActions(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    //    DROPDOWN MENUSUNDEN SELECTBY VISIBLE TEXT ILE SECIM YAPMAK
    public static void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }


    //    DROPDOWN MENUSUNDEN  VERILEN INDEX SELECTBY INDEX ILE SECIM YAPMAK
    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }


    //    DROPDOWN MENUSUNDEN  VERILEN VALUE DEGERI KULLANILARAK  SELECTBY VALUE ILE SECIM YAPMAK VE BUTUN SECENEKLERIN SAYISINI BULMAK ICIN
    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: " + elementCount.size());
    }


    //TEXT VALUESI VERILEN ELEMENTE CLICK YAPMAK ICIN
    public static void waitAndClickLocationText(WebElement element, String value) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + value + "']")).click();
    }


    //SEKME NUMARASI VERILEREK PENCERELER ARASI GECIS YAPMAK ICIN
    public static void switchToWindowWithSekme(int sekmeNumarasi) {
        List<String> tabs = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(sekmeNumarasi - 1));
    }


    //DROP DOWN MENUSUNDE ISTEDIGIMIZ OGEYE TIKLAMAK ICIN
    public static void selectFromDropdown(WebElement dropdown, String secenek) {
        List<WebElement> tumOptions = dropdown.findElements(By.tagName("option"));
        for (WebElement w : tumOptions) {
            if (w.getText().equals(secenek)) {
                w.click();
                break;
            }
        }
    }


    //TAM SAYFA ACLIR REKLAM KAPATMAK ICIN
    public static void clickOutside() {
        Actions action = new Actions(Driver.getDriver());
        action.moveByOffset(0, 0).click().build().perform();
    }


    //      Sayfanın altından kayan reklamı kapatmak için oluşturulan method. Reklamın açıldığı yerde kapatmak methodu çağırın.
    public static void kayanReklamiKapat() throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);
    }


    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(element).perform();
    }


    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
        Actions actions = new Actions(driver);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
    }


    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
        Actions actions = new Actions(Driver.getDriver());
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_UP).perform();
    }


    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions() {
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).build().perform();
    }


    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }


    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
        Actions actions = new Actions(Driver.getDriver());
        new Actions(Driver.getDriver()).dragAndDrop(source, target).perform();
    }


    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
        Actions actions = new Actions(Driver.getDriver());
        new Actions(Driver.getDriver()).dragAndDropBy(source, x, y).perform();
    }


    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }


    //DOSYA ADI VERILEREK EKRAN GORUNTUSU ALMA



    public static String getScreenshot(String name) throws IOException {
//        THIS METHOD TAKES SCREENSHOT AND STORE IN /test-output FOLDER
//        NAME OF THE SCREEN IS BASED ON THE CURRENT TIME
//        SO THAN WE CAN HAVE UNIQUE NAME
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        public static final String path = date.toString();
        // TakesScreenshot is an interface of selenium that takes the screenshot. SAME IS IN THE HOOKS
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //    VERILEN ELEMENTIN EKRAN GORUNTUSUNU ALMA

    public static void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        FileUtils.copyFile(image, new File(path));
    }


    //WEBTABLE'DEN DATA CEKMEK
    public static void webTableDataPrint(String tableNumber, String rowNumber, String columnNumber) {
        String rowData = Driver.getDriver().findElement(By.xpath("//table[" + tableNumber + "]//tr[" + rowNumber + "]//td[" + columnNumber + "]")).getText();
        System.out.println("rowData = " + rowData);
    }


    //JAVA SCRIPT ILE SAYFANIN EN ALTINA IN BU method ile sayfanin en altina inebiliriz
    public static void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    //JAVA SCRIPT ILE  SAYFANIN EN USTUNE CIK. Bu method ile sayfanin en ustune cikabiliriz

    public static void scrollTopJS() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

    }


    //   girmis oldugum metni elemente yazdirir bu method sendKeys metotuna bir alternatifdir.
//    sendKeys oncelikli tercihimizdir
    public static void typeWithJS(String metin, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + metin + "')", element);
    }


    //  JAVA SCRIPT ILE   input elementindeki degerleri(value) al
//   Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür

    public static void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("Kutudaki value: " + text);
    }


 /*
   // SHADOW ELEMENTLERI LOCATE ETMEK ICIN ASAGIDAKI YOL IZLENIR
    Thread.sleep(1000);
        SearchContext shadow1 = Driver.getDriver().findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        WebElement book = shadow1.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(book.isDisplayed());
 */


    /*


    SLIDER (FILTER) DE ISTENEN DEGERI GONDERMEK ICIN ASAGIDAKI YOL IZLENIR
        JavascriptExecutor j = (JavascriptExecutor) Driver.getDriver();
        WebElement ads = driver.findElement(By.xpath("//*[@id='max_price']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", ads);
        ads.clear();
        ads.sendKeys("450");
     */

    /*
    Basic Authentication
    ALERT SEKLINDE YUKARIDAN ACILAN PENCERELERE KULLANICI ADI VE PASSWORD YAZDIRABILMEK ICIN
    (NORMAL ALERT'LERLE DEGER GONDEREMEDIKLERIMIZIN) ICIN
        //Kullanici Adi ve Sifreyi gir
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        ILK admin: username
        Ikinci admin: password
        adres satirinin sonuna da "basic_auth" ifadesi yazilacak


        public void basicAuthentication(WebElement target, String adminName, String password){
    Driver.getDriver().get("https://"+adminName+":"+password+target.getText().substring(8));

}

     */

    public static void basicAuthentication(String url, String adminName, String password) {
        Driver.getDriver().get("https://" + adminName + ":" + password + url.substring(8));

    }

    public static void verifyElementDisplayed(WebElement userID) {
    }
}

