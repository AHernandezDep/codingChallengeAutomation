package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import services.PokemonServices;

import java.util.List;
import java.util.Optional;

public class PokemonSteps {
    private final PokemonServices pokemonService = new PokemonServices();
    private String selectedPokemon;
    private String selectedAbility;
    private Response response;

    @Given("I get a random Pokemon from the list")
    public void getRandomPokemon() {
        Optional<String> randomPokemon = pokemonService.getRandomPokemon();
        Assert.assertTrue("No Pokemon found.", randomPokemon.isPresent());
        selectedPokemon = randomPokemon.get();
    }

    @When("I get the details of the Pokemon")
    public void getPokemonDetails() {
        response = pokemonService.getPokemonDetails(selectedPokemon);
        Assert.assertEquals(
                "Pokemon API did not respond correctly.",
                200,
                response.getStatusCode()
        );
    }

    @When("I get the details of the ability for the selected Pokemon")
    public void getAbilityDetails() {
        Optional<String> ability = pokemonService.getFirstAbility(selectedPokemon);
        Assert.assertTrue("No abilities found for Pokemon.", ability.isPresent());
        selectedAbility = ability.get();
        response = pokemonService.getAbilityDetails(selectedAbility);
        Assert.assertEquals(
                "Pokemon API did not respond correctly.",
                200,
                response.getStatusCode()
        );
    }

    @Then("The ability name should match")
    public void verifyAbilityName() {
        String abilityName = response.jsonPath().getString("name");
        Assert.assertEquals("Skill name does not match.",
                abilityName, selectedAbility);
    }

    @Then("The Pokemon should be in the ability's Pokemon list")
    public void verifyPokemonInAbilityList() {
        List<String> pokemonNames = pokemonService.getPokemonWithAbility(selectedAbility);
        Assert.assertTrue("The Pokemon is not listed in the ability list.",
                pokemonNames.contains(selectedPokemon));
    }

    @Given("I look for a Pokemon named {string}")
    public void lookForPokemon(String pokemonName) {
        response = pokemonService.getPokemonDetails(pokemonName);
        Assert.assertEquals(
                "Pokemon API did not respond correctly.",
                200,
                response.getStatusCode()
        );
        selectedPokemon = response.jsonPath().getString("name");
        Assert.assertNotNull("No information found for the Pokémon",
                selectedPokemon);
    }

    @Then("The pokemon type is {string}")
    public void verifyPokemonType(String typePokemon) {
        List<String> types = pokemonService.getPokemonTypes(selectedPokemon);
        Assert.assertTrue("Pokemon type does not match expected type",
                types.contains(typePokemon));
    }
}