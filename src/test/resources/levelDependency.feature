Feature:  Language dependency

  Scenario: Check language dependency level
    Given I am on the Home page
    When I click on the Menu bar button
    And I click on particular game
    And I Get information about a specific game from the site's API
    And I Parse response to get the most voted option in the Language Dependence poll
    Then Assert Language Dependence text presented in the game page Description block equals the most voted Language Dependence level.
