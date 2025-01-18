
Feature: Test phone retrieval and database storage

  Scenario: Retrieve phones from Allo.ua and store in the database
    Given the database connection is set up
    When I search for "iphone" on Allo.ua
    And I retrieve the first 3 phones
    Then I check and insert the phones into the database
