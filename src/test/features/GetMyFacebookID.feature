Feature: Get my Facebook ID by hitting graph API

  @complete
  Scenario: User calls facebook API to get ID and email address
    Given user already has a facebook account
    When user retrives information from the facebook API
    Then the API response code is 200
    And response includes the following data
      | id   | 10154892861315503 |
      | name | Sumit Roy         |

  @complete
  Scenario: Verify that the facebook API responds in the given time
    Given user already has a facebook account
    When user retrives information from the facebook API
    Then the API response code is 200
    And total time taken by the API is 2000 milliseconds
