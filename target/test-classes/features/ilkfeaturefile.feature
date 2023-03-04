@google_search
Feature: ilk feature file

  Background: Google_sayfasina_git
    Given kullanici google gider


  @iphone
  Scenario: TC01_google_iphone_arama
    When kullanici iphone icin arama yapar
    Then sonuclarda iphone oldugunu dogrular
    Then close the application

  @tesla
  Scenario: TC02_google_tesla_arama
    When kullanici tesla icin arama yapar
    Then sonuclarda tesla oldugunu dogrular
    Then close the application

    When kullanici tesla icin arama yapar
    Then sonuclarda tesla oldugunu dogrular


