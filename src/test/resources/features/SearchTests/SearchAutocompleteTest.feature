# Arama menüsü autocomplete case :

# Senaryo 1
# Arama çubuğuna 3 karakterden daha az (ör. "ko") değer girildiğinde otomatik tamamlama (autocomplete) menüsünün açılmaması.

# Negatif Senaryo 2
# Arama çubuğuna 3 karakterden daha fazla (ör. "kot") değer girildiğinde otomatik tamamlama (autocomplete) menüsünün açılması.

  Feature: Search input autocomplete test

    @navbar
    Scenario Outline: Check the autocomplete box is not visible after send 2 keys
      Given User navigate to website
      When Enter "<keys>" in search input
      Then User shouldn't see the autocomplete box
      Examples:
        |keys|
        |ko|

    @navbar
    Scenario Outline: Check the autocomplete box is visible after send 3 keys
      Given User navigate to main page
      When Enter "<keys>" in search input
      Then User should see the autocomplete box
      Examples:
        | keys |
        | kot  |