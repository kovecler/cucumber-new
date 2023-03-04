
@manager_login_test

Feature: US167854_manager_login_test

  Scenario Outline: TC01_kullanici_tum_manager_login_bilgileriyle_ giris_yapabilmeli

    Given kullanici "https://www.bluerentalcars.com/" gider
    When kullanici login sayfasina gider
    And kullanici adini "<username>" girer
    And kullanici sifreyi "<password>" girer
    And kullanici login buttoning basar
    Then login islemi gerceklesir
    Then close the application

    Examples: user_data

      | username                       | password  |
      | sam.walker@bluerentalcars.com  | c!fas_art |
      | kate.brown@bluerentalcars.com  | tad1$Fas  |
      | raj.khan@bluerentalcars.com    | v7Hg_va^  |
      | pam.raymond@bluerentalcars.com | Nga^g6!   |


