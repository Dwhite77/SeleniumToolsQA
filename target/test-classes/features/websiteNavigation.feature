# Feature, ability and business need mean the same thing
# whats the point? anyone can write more scenarios!
# minimise use of and and but

Feature: Ability to navigate the toolsQA website
  @tag("elements")
  Scenario: Navigating to the elements page from the homepage
    Given I am on the toolsQA homepage
    When I click on the elements link
    Then I will go to the elements page

  @tag("forms")
  Scenario: Navigating to the forms page from the homepage
    Given I am on the toolsQA homepage
    When I click on the forms link
    Then I will go to the forms page

  @tag("alerts")
  Scenario: Navigating to the Alerts page from the home page
    Given I am on the toolsQA homepage
    When I click on the alerts link
    Then I will go to the alerts page

  Scenario: Navigating to the BookStore Page from the home page
    Given I am on the toolsQA homepage
    When I click on the BookStore link
    Then I will go to the BookStore page

  Scenario: Navigating to the interactions Page from the home page
    Given I am on the toolsQA homepage
    When I click on the interactions link
    Then I will go to the interactions page

  Scenario: Navigating to the Widgets Page from the home page
    Given I am on the toolsQA homepage
    When I click on the Widgets link
    Then I will go to the Widgets page

