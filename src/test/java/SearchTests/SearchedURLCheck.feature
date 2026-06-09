# 4- Seneryo : Searched URL Check
# Arama sonuç sayfasında URL'nin girilen anahtar kelimeyi (ör. ?q=hırka) doğru taşıdığının test edilmesi.

  Feature: Searched URL Check

    @Regression
    Scenario: Find the text in url after search
      When User navigate to website
      And Enter words in search input and search
        | word1  | word2  |
        | mavi   | tişört |
      Then User must see searched words in url
        |  word1 |  word2 |
        |  mavi  | tişört |