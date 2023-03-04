@personel_olusturma
Feature: personel_olusturma

  Scenario Outline: TC01_personel_olustur
    Given kullanici "https://editor.datatables.net/" gider
    When kullanici new butonuna tiklar
    And kullanici first name "<firstname>" girer
    And kullanici last name "<lastname>" girer
    And kullanici positions "<positions>" girer
    And kullanici office "<office>" girer
    And kullanici extension "<extension>" girer
    And kullanici start_date "<start_date>" girer
    And kullanici salary "<salary>" girer
    And kullanici create buttonuna basar
    When kullanici firstname ile "<firstname>" arar
    Then firstnamenin "<firstname>" olustugunu dogrular
    Then close the application

    Examples: personel_bilgileri

      | firstname | lastname | positions | office   | extension | start_date | salary  |
      | john      | walker   | SDET      | Istanbul | 345       | 2023-03-01 | 100000  |
      | zeynep    | black    | devoloper | ankara   | 256       | 2023-04-01 | 15000   |
      | mustafa   | tez      | BA        | kutahya  | 274       | 2023-04-21 | 176589  |
      | erkam     | genc     | devoloper | burdur   | 456       | 2023-03-30 | 2135000 |
      | yunus     | yilmaz   | QA        | isparta  | 421       | 2023-04-15 | 2653000 |


