# 2- Beden seçimi yapılmadan "Sepete Ekle" butonuna tıklandığında "Lütfen beden seçiniz" veya benzeri bir hata mesajının alınması.

  Feature: Select A Variation Test

    Background:
      Given User navigate to website

    Scenario Outline: User click to add to cart then user able to see select a variation message.
      Given Enter "<productCategories>" in search input and search
      And Click to a product in search page and navigate to product page
      When User click to add to cart button
      Then User able to see "select a variation" message

      Examples:
        | productCategories |
        | tişört            |

