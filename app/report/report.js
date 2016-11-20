$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DiscAlive.feature");
formatter.feature({
  "line": 1,
  "name": "DiscAlive",
  "description": "",
  "id": "discalive",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "When there are no RFIDs in Proximity",
  "description": "",
  "id": "discalive;when-there-are-no-rfids-in-proximity",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "there are no RFIDs in Proximity",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I should see \"No RFIDs Found\"",
  "keyword": "Then "
});
formatter.match({
  "location": "rfid_steps.there_are_no_RFIDs_in_Proximity()"
});
formatter.result({
  "duration": 123025135,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat com.theagiletester.discalive.step_definitions.rfid_steps.there_are_no_RFIDs_in_Proximity(rfid_steps.java:17)\n\tat ✽.Given there are no RFIDs in Proximity(DiscAlive.feature:3)\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "No RFIDs Found",
      "offset": 14
    }
  ],
  "location": "rfid_steps.i_should_see(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 6,
  "name": "Detect RFIDs in Proximity",
  "description": "",
  "id": "discalive;detect-rfids-in-proximity",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am in proximity of an RFID Tag",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should be able to detect the RFID Tag",
  "keyword": "Then "
});
formatter.match({
  "location": "rfid_steps.i_am_in_proximity_of_an_RFID_Tag()"
});
formatter.result({
  "duration": 276585,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat com.theagiletester.discalive.step_definitions.rfid_steps.i_am_in_proximity_of_an_RFID_Tag(rfid_steps.java:29)\n\tat ✽.Given I am in proximity of an RFID Tag(DiscAlive.feature:7)\n",
  "status": "pending"
});
formatter.match({
  "location": "rfid_steps.i_should_be_able_to_detect_the_RFID_Tag()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 10,
  "name": "Read an NFC RFID Tag",
  "description": "",
  "id": "discalive;read-an-nfc-rfid-tag",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I can read an RFID Tag",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I can display the information on it",
  "keyword": "Then "
});
formatter.match({
  "location": "rfid_steps.i_can_read_an_RFID_Tag()"
});
formatter.result({
  "duration": 263420,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat com.theagiletester.discalive.step_definitions.rfid_steps.i_can_read_an_RFID_Tag(rfid_steps.java:41)\n\tat ✽.Given I can read an RFID Tag(DiscAlive.feature:11)\n",
  "status": "pending"
});
formatter.match({
  "location": "rfid_steps.i_can_display_the_information_on_it()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 14,
  "name": "List an RFID Tag",
  "description": "",
  "id": "discalive;list-an-rfid-tag",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I my Android phone is in proximity of an NFC RFID",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I should see the RFID",
  "keyword": "Then "
});
formatter.match({
  "location": "rfid_steps.i_my_Android_phone_is_in_proximity_of_an_NFC_RFID()"
});
formatter.result({
  "duration": 386046,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat com.theagiletester.discalive.step_definitions.rfid_steps.i_my_Android_phone_is_in_proximity_of_an_NFC_RFID(rfid_steps.java:53)\n\tat ✽.Given I my Android phone is in proximity of an NFC RFID(DiscAlive.feature:15)\n",
  "status": "pending"
});
formatter.match({
  "location": "rfid_steps.i_should_see_the_RFID()"
});
formatter.result({
  "status": "skipped"
});
});