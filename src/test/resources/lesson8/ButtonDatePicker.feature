Feature: Check Button DatePicker

  Background:
  Given I am on Events page

    Scenario:
      When I press button DatePicker
      And I choose date
      And I press button Apply
      Then I see chosen Date

