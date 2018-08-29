Feature: Google Automation

  Scenario: Open Google
    Given User opens the browser
    And Enters Google URL
    When URL is open
    Then The User can type the Search Parameter "Hello World"

  Scenario: Search Google on Google
    Given User opens Google
    When Searching for "Google"
    Then The first result is Google Homepage