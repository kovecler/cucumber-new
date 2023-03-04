@allure2you_test
Feature:Allure2you_login_Test

  Scenario:Allure2you_Login_Bilgileriyle_Giriş_Yapabilme
    Given Kullanici sayfaya sayfasına gider
    When Kullanıcı myAccount tiklar.
    And Kullanici email girer
    And Kullanici password girer
    And kullanici SIGN IN tiklar
    And Soldaki Account details butonunu tıklar.
    Then First name bilgilerini görür
    Then Last name bilgilerini görür
    Then Display name bilgilerini görür
    Then Email address bilgilerini görür.