Feature: Feature to test login functionaly

  Scenario: Verify login is sucessful with vaild credentials.
    Given browser is open
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  Scenario: Verify login is unsucessfull with vaild username but invalid password.
    Given browser is open
    And user is on login page
    When user enters vaild username but invalid password
    And clicks on login button
    Then error message pops up

  Scenario: Verify login is unsucessfull with invaild username but valid password.
    Given browser is open
    And user is on login page
    When user enters invaild username but valid password
    And clicks on login button
    Then error message pops up

  Scenario: Verify Need Help button works as intended.
    Given browser is open
    And user is on login page
    When user clicks Need Help button
    Then user is navigated to the login help page

  Scenario: Verify enter key on the keyboard works as intended on the login page.
    Given browser is open
    And user is on login page
    When user enters username and password
    And presses enter key on keyboard
    Then user is navigated to the home page

  Scenario: Verify the Remember Me feature works as intended.
    Given browser is open
    And user is on login page
    When user enters username and password
    And clicks Remember Me checkbox and login button
    Then user is navigated to the home page
    And exits site
    Given browser is open
    When user returns to site they will be logged in
