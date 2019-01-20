Feature: Purchase
Background:
  Given User is on the Home page

Scenario: As a new user purchase a product
  When User search for the product "T-shirts"
  Then Search results for "T-shirts" product are displayed
  Then User add product "T-shirts" to cart and continue to cart summary page
  Then Verify product detail for "T-shirts" and continue to SignIn page
  And User create a new account and continue to delivery address page
  |firstName|Tester|
  |lastName|TesterLastName|
  |streetAddress|StreetAddress|
  |city|New York|
  |state|Alaska|
  |postalCode|99501|
  |country|United States|
  |mobile|1234567896|
  Then Verify delivery address, invoice address and continue to Shipping Page
    |firstName|Tester|
    |lastName|TesterLastName|
    |streetAddress|StreetAddress|
    |city|New York|
    |state|Alaska|
    |postalCode|99501|
    |country|United States|
    |mobile|1234567896|
  And User agree the terms and conditions and continue to payment page
  And User select payment method as Check and confirm order
  Then Order placed successfully  message is displayed

  Scenario: As an existing user purchase a product
    Given User Sign in to the application using "email3179@sample3179.com" email and "testPassword" password
    Then  Verify user with "Tester" first name and "TesterLastName" password  is successfully signed in to application
    When User search for the product "T-shirts"
    Then Search results for "T-shirts" product are displayed
    Then User add product "T-shirts" to cart and continue to cart summary page
    Then Verify product detail for "T-shirts" and continue to delivery address page
    Then Verify delivery address, invoice address and continue to Shipping Page
      |firstName|Tester|
      |lastName|TesterLastName|
      |streetAddress|StreetAddress|
      |city|New York|
      |state|Alaska|
      |postalCode|99501|
      |country|United States|
      |mobile|1234567896|
    And User agree the terms and conditions and continue to payment page
    And User select payment method as Check and confirm order
    Then Order placed successfully  message is displayed
