Feature: Information test

  Scenario: Navigate to Game page and check information, by compering data from API And Ui

    Given I am on the Home page
    When I click on the menu Bar Button
    And I click on particular game
    And I Get information about a specific game from the site's API
    And I Parse response to get the most voted option in the Language Dependence poll
    Then Assert Language Dependence text presented in the game page Description block equals the most voted Language Dependence level.
