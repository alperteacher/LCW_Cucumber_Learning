# Arama menüsü 404 case :

# Seneryo
# Geçerli bir karakter dizisi "pantolon" diye arandığında arama sayfasında "pantolon" İÇİN SONUÇLAR" başlığının çıkması

# Negatif Seneryo
# Alakasız veya geçersiz bir karakter dizisi ("asdfgh123") aratıldığında, sistemin "Böyle bir ürün bulunamadı"
# sayfasına yönlendirmesi.

Feature: Search Keys Validation

  Background:
    Given User navigate to main page

  @Regression
  Scenario Outline: Searching a product with search input then user must see keys in the page
    Then Enter "<productName>" in search input and search
    Then User must see the search page with "<productName>" header

    Examples:
      | productName |
      | Beyaz Tişört |
      | Mavi Pantolon |

  @Regression
  Scenario Outline: Searching incorrect words with search input then user must see 404 page
    Then Enter "<productName>" in search input and search
    Then User must see the no found page with "<productName>"
    Examples:
      | productName |
      | asdaskdmal32040 |
      | *0*090903514252 |
