@failed_scenario
  Feature: hooks_test
    Background: Google_sayfasina_git
      Given kullanici google gider

#bu sayfadaki scenariolar ekran goruntusu kaydetmesi icin bilerek FAILED olacak sekilde yazilmistir

    Scenario: TC01_google_iphone_arama
      When kullanici "iphone" icin arama yapar
      Then sonuclarin "apple" icerdigini dogrula
      Then close the application


    Scenario: TC02_google_tesla_arama
      When kullanici "tesla" icin arama yapar
      Then sonuclarin "iphone" icerdigini dogrula
      Then close the application
