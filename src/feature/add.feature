@tag
Feature: User adds product to the cart and attempts checkout
  This feature allows users to add product to the cart and attempt checkout.

Background:
  Given user landed on home page
  And user accepted cookies

  @tag1
  Scenario Outline: Successful adding products to the cart via PLP and PDP
Given the user navigates to the PLP page
Then the user adds a product to the cart from the PLP
And adds more products from the recommendations on the cart page
And adds another product from the product detail page


  Scenario Outline: Checkout Process
    Given user has products in my cart
    When user proceeds to checkout and fills in email <email>
    And user fills in password <password> and confirm password <cpassword>
    Then the user fills in the address containing:
      | Name  | Surname | Social | Street                    | Pincode | City          | Phone Number   |
      | <name> | <surname> | <soc> | <street>                 | <code>  | <city>       | <no>           |

    Examples:
      | email                        | password                   | cpassword                   | name  | surname | soc   | street                       | code  | city          | no          |
      | pafekiv3931@almaxen.com     | pafekiv393@almaxen.com    | pafekiv393@almaxen.com     | Test  | Test    | Test  | 41 avenue de Provence       | 59300 | Villeparisis | 0339630861 |