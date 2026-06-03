# Arama menüsü autocomplete case :

# Senaryo 1
# Arama çubuğuna 3 karakterden daha az (ör. "ko") değer girildiğinde otomatik tamamlama (autocomplete) menüsünün açılmaması.

# Negatif Senaryo 2
# Arama çubuğuna 3 karakterden daha fazla (ör. "kot") değer girildiğinde otomatik tamamlama (autocomplete) menüsünün açılması.

  Feature: Search input autocomplete test

    Scenario: Check the autocomplete box is not visible after send 2 keys
      Given User navigate to main page
      When Enter "ko" in search input and user shouldn't see the autocomplete box


    Scenario: Check the autocomplete box is visible after send 3 keys