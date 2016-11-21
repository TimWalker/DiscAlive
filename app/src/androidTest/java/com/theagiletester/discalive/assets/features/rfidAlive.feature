Feature: RFID Alive
  As a user of DiscAlive! I'd like to interact with RFID enabled SmartDiscs
  So that they can tell me about themselves. I can use the information to understand
  the best use for the Disc and any tips or reviews,

  Background: Begin the main activity
    Given I am on the DiscAlive! Main Activity

  Scenario: RFID Present
    As a user of DiscAlive! using RFID enabled SmartDiscs I want DiscAlive! to recognize
    a disc and then tell me all about it

    When there is an RFID enabled SmartDisc detected
    And I click on the DiscAlive! Button
    Then DiscAlive! will tell me all about the disc

    Then I just admire the state for 120 seconds

  @wip
  Scenario: RFID is not Present
    As a user of DiscAlive! using RFID enabled SmartDiscs when there are no SmartDiscs within range
    I want DiscAlive! to let me know so that I dont waste time waiting

    Given There isn't an RFID enabled SmartDisc detected
    Then DiscAlive! will let me know so I don't waste my time



