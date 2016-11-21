@wip
Feature: UI
  As a user of DiscAlive! I want a Landing Page That is awesome!

  The first time I start the DiscAlive! application I will see a very simple interaction
  screen that is stunning in appearance and incredibly simple. Like Google. Just an obvious
  and comfortable image and a button to bring it to life.

  Scenario: There is a cool and simple initial user experience

  As a user of DiscAlive on the Main Activity Page

    o I want a cool and very simple user experience
      So that I will enjoy the app and talk about it to others.
    o I want to see some text that shows I am in DiscAlive!
      So that I'm not confused about the app
    o I want a button that brings the application to life
      So that I can start interacting with it

    Given I am on the DiscAlive! Main Activity
    Then there is a cool image
    And there is a cool text that says "DiscAlive!"
    And there is a cool button

    Then I just admire the state for 20 seconds

