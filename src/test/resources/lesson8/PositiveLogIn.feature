Feature: Positive LogIn

  Background:
    Given I am on home page

    Scenario:
      When I click button Enter for authorization
      And I fill field Login
      And I fil field Password
      And I click button Enter
      Then I see success authorization
