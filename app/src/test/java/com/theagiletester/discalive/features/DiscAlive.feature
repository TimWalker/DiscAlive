Feature: DiscAlive
  Scenario: When there are no RFIDs in Proximity
    Given there are no RFIDs in Proximity
    Then I should see "No RFIDs Found"

  Scenario: Detect RFIDs in Proximity
    Given I am in proximity of an RFID Tag
    Then I should be able to detect the RFID Tag

  Scenario: Read an NFC RFID Tag
    Given I can read an RFID Tag
    Then I can display the information on it

  Scenario: List an RFID Tag
    Given I my Android phone is in proximity of an NFC RFID
    Then I should see the RFID