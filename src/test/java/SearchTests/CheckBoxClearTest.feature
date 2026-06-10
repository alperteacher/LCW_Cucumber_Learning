
  # 2- Seneryo : Checkbox Clear Function
  # Arama çubuğuna metin yazıldıktan sonra yanda beliren temizle (çarpı/x) ikonuna tıklanarak input alanının boşaltılması.

    Feature: Checkbox Clear

      Background:
        Given User navigate to website

      Scenario Outline: Validation of input clearing
        When Enter "<keys>" in search input
        And Click to close button in input
        Then Inputs area must be clear

        Examples:
          |keys|
          |abcdef|
          |ajısrj|
