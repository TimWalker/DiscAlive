@wip
Feature: DiscAlive! Backlog
  As a mobile developer I'd like a backlog of User Stories in Gherkin so that I can
  use them to guide my development and make priority decisions.

  Scenario: DiscAlive Flight paths
    Given I have recognized a SmartDisc
    Then I'd like to see the floght path for that model

  Scenario: Create a Bag
    Given I am creating a bag
    When I add the following SmartDiscs! to the bag
    Then I can get a listing of the discs in my bag

  Scenario: Tell me what disc to throw
    Given a bag
    When I ask DiscAlive! to tell me what disc to throw given the conditions
    Then DiscAlive! will make recommendations

  Scenario: Tell me a story
    Given I have recognized a SmartDisc
    Then I'd like to hear about that disc

  Scenario: Test Structures
    Given I have some tests that can only be run on android hardware
    Then I'd like to use a tag to segregate these from the Emulator tests

