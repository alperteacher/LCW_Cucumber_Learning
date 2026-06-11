

  # 1- Seneryo : Searched Words In Products

    # Arama çubuğuna spesifik bir kelime ("hırka") yazıp Enter'a basıldığında çıkan ürünlerin
    # en az 10 tanesinin isim veya kategorisinde bu kelimenin geçtiğinin doğrulanması.


    Feature: Search Keys In Products Test

      Background:
        Given User navigate to website

      @Regression
      Scenario Outline: Validate the searched keys in product names
        When Enter "<productName>" in search input and search
        And User must see the search page with "<productName>" header
        Then User must see "<productName>" in products 10 at least

        Examples:
          |productName|
          |hırka|