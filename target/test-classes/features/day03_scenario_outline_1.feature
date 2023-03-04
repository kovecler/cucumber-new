@scenario_outline_1
Feature: arama_feature_2

  Background: Google_sayfasina_git
    Given kullanici google gider


  Scenario Outline: arama_test
    When kullanici "<product>" icin arama yapar
    Then sonuclarin "<product>" icerdigini dogrula
    Then close the application

    Examples: data
      | product |
      | iphone  |
      | tv      |
      | flower  |
      | cat     |
      | dog     |
      | tesla   |



      #DEGISIKLIKLER
  #scenario-> Scenario Outline
  # "" -> "<sutun_ismi>"
  # Examples kelimesi Scenario Outline kelimesinden sonra kullanilmak zorundadir. Data anlamindadir
  # Examples verilerin kullanildigi yer'dir