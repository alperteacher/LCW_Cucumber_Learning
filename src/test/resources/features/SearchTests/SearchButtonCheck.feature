# 5- Seneryo : Search Button Check
# Klavye "Enter" tuşu haricinde büyüteç ikonuna tıklandığında da arama işleminin başarıyla başlaması.

  Feature: Search Button Check

    @navbar
    Scenario Outline:
      Given User navigate to website
      When Enter "<searchKey>" in search input
      And Click to search button
      Then User must see searched word in url
        | word1 |
        | kazak |

        Examples:
          |searchKey|
          |  kazak  |