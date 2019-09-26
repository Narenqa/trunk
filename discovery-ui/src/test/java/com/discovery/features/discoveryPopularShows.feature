Feature: Verify Favorite Shows
  1.	Navigate to https://go.discovery.com/
  2.	Scroll down to popular shows
  3.	Go to the last video by pressing the icon “>”
  4.	Once you reach the last video, click on "EXPLORE THE SHOW"
  5.	Click on "SHOW MORE" and you will see the list of shows
  6.	Click on "SHOW MORE" again and few shows will be added
  7.	Create a new file and write all the show titles and duration into it.

  @sanity
  Scenario Outline: Discovery
    Given I navigate to "<baseUrl>"
    Then I scroll down to popular shows
    Then Go to the last video by pressing the icon >
    Then Once you reach the last video click on "EXPLORE THE SHOW"
    Then Click on "SHOW MORE" and you will see the list of shows
    And Click on "SHOW MORE" again and few shows will be added
    Then Create a new file and write all the show titles and duration into it
  Examples:
  |	baseUrl		                |
  | https://go.discovery.com/   |


