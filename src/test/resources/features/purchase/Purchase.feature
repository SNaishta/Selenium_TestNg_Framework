Feature: End customers Purchase flow
  In order to complete purchase flow for a product
  as an end customer
  I want to be able to login into my account, view and sort the items and add them to my basket.

  @EndToEnd
  Scenario: TC_001 Success scenario on Customers end to end purchase flow.
    Given I login to the application as standard user
    And sort the products by high to low Price
    And add the cheapest and the 2 costliest products to the basket
    When I complete the checkout process with my information
    And confirm the transaction details
    Then my purchase is complete
