@tag
Feature: Sahi page object test with Mozilla Firefox
  I want to test each of the objects on the SAHI page as a technical test.
  
  @links
  Scenario: Links
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/linkTest.htm"
    And I want press link "linkByContent"
    When I want to return to the previous page
    And I want press link "linkByHtml"
    And I close browser


 @selects
 Scenario: Selects
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/selectTest.htm"
    Then I want select combobox "s1Id"
    And I want select combobox "s2Id"
    And I want select combobox "s3Id"
    And I want select combobox "s4Id"
    And I want select combobox "s1"
    And I close browser

@iframes
Scenario: iframes
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/iframesTest.htm"
    Then I want click in link frame "select test"
    And I want click in link frame "react test"
    And I want click in button Click Me
    And I close browser

@clicks
Scenario: clicks
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/clicks.htm"
    When I want click in button "click me"
    Then I want click in button "dblclick me"
    And I want click in button "right click me"
    And I close browser

@alerts
Scenario: Alerts
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/confirmTest.htm"
    When I want search button and "Click For Confirm"
    When I want search button and "Click For Confirm Cancel"
    And I close browser

@text
Scenario: Alerts with text
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/promptTest.htm"
    When I want search button and Click For Prompt
    And I close browser

@new_tab
Scenario: new tab
    Given I use Mozilla Firefox and I want to enter the page sahi link "http://sahitest.com/demo/index.htm"
    When I want click in link for new tab
    And I close browser