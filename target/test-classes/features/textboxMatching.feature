@tag("textboxmatching")
Feature: Ability to have the typed text show up in the output
  Scenario: Inputting text into the name box outputs the name after submit is pressed
    Given I am on the Elements page
    When I click on the TextBox button
    And I input text into the name box
    And I press the submit button
    Then The inputted name text should be output correctly

  Scenario: Inputting text into the email box outputs the name after submit is pressed
    Given I am on the Elements page
    When I click on the TextBox button
    And I input text into the email box
    And I press the submit button
    Then The inputted email text should be output correctly

  Scenario: Inputting text into the Current Address after submit is pressed
    Given I am on the Elements page
    When I click on the TextBox button
    And I input text into the Current Address box
    And I press the submit button
    Then The inputted Current Address text should be output correctly

  Scenario: Inputting text into the Permanent Address after submit is pressed
    Given I am on the Elements page
    When I click on the TextBox button
    And I input text into the Permanent Address box
    And I press the submit button
    Then The inputted Permanent Address text should be output correctly