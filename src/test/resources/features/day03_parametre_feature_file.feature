@parametre
Feature: arama_feature

  Background: Google_sayfasina_git
    Given kullanici google gider



  Scenario: TC01_google_iphone_arama
    When kullanici "iphone" icin arama yapar
    Then sonuclarin "iphone" icerdigini dogrula
    Then close the application


  Scenario: TC02_google_tesla_arama
    When kullanici "tesla" icin arama yapar
    Then sonuclarin "tesla" icerdigini dogrula
    Then close the application


  Scenario: TC03_google_wather_arama
    When kullanici "wather" icin arama yapar
    Then sonuclarin "wather" icerdigini dogrula
    Then close the application



  Scenario: TC04_google_porcelain_tea_pot_arama
    When kullanici "porcelain tea pot" icin arama yapar
    Then sonuclarin "porcelain tea pot" icerdigini dogrula
    Then close the application



  Scenario: TC05_google_skateboard_arama
    When kullanici "skateboard" icin arama yapar
    Then sonuclarin "skateboard" icerdigini dogrula
    Then close the application


#"veri" ->feature file'i parametretize etmek demektir