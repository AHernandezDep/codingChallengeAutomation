@POKEMON
Feature: API Testing with Java and Cypress

  Scenario: Validate Pokemon and its ability
    Given I get a random Pokemon from the list
    When I get the details of the Pokemon
    And I get the details of the ability for the selected Pokemon
    Then The ability name should match
    And The Pokemon should be in the ability's Pokemon list

  Scenario Outline: Verify Pokemon information
    Given I look for a Pokemon named "<pokemonName>"
    Then The pokemon type is "<typePokemon>"

    Examples:
      | typePokemon | pokemonName |
      | flying      | charizard   |
      | water       | wartortle   |
      | poison      | bulbasaur   |
      | grass       | venusaur    |

