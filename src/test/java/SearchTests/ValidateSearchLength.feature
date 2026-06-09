# 9- Seneryo : Validate search length
# Arama sonucunda sayfanın üstünde yazan "X adet ürün bulundu" metni ile grid içindeki (veyahut sayfa başı) ürün sayısının uyumlu olması.

  Feature: Validate search length
    Scenario Outline:
      Given User navigate to website
      When Enter "<productName>" in search input and search
      And User must see the search page with "<productName>" header
      Then Product size must be same with search page info
      Examples:
        | productName |
        | Ütü        |