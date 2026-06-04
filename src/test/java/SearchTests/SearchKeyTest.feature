
  # 1- User anasayfaya gider
  # 2- Arama inputuna kolsuz gömlek yazar
  # 3- İlk ürüne tıklar
  # 4- Açıklamada kolsuz ve gömlek kelimelerinin geçtiği onaylanır

  # https://www.lcwaikiki.com/

    Feature: Search Key Test

      Scenario Outline: User search keys, these keys must be in the product page
        Given User navigate to main page
        When Enter "<productName>" in search input and search
        And Click to a product in search page and navigate to product page
        Then User be able to see "Kolsuz" and "Tişört" in the product description
        Examples:
          |productName|
          |Kolsuz Tişört|