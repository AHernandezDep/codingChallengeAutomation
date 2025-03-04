package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PokemonServices {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    /**
     * Sends a GET request to the API and returns the response.
     * @param endpoint The resource path.
     * @return API Response.
     */
    private Response sendGetRequest(String endpoint) {
        RequestSpecification request = RestAssured.given()
                .baseUri(BASE_URL)
                .header("Accept", "application/json")
                .log().uri();
        return request.when().get(endpoint).then().extract().response();
    }

    /**
     * Retrieves a list of available Pokemon from the API.
     * @return List of Pokemon names.
     */
    public List<String> getAllPokemon() {
        Response response = sendGetRequest("pokemon");
        return response.jsonPath().getList("results.name");
    }

    /**
     * Retrieves a random Pokemon from the available Pokemon list.
     * @return Name of the randomly selected Pokemon.
     */
    public Optional<String> getRandomPokemon() {
        List<String> pokemonList = getAllPokemon();
        return pokemonList.isEmpty()
                ? Optional.empty()
                : Optional.of(pokemonList.get(new Random().nextInt(pokemonList.size())));
    }

    /**
     * Retrieves details of a specific Pokemon.
     * @param pokemonName Name of the Pokemon to search.
     * @return Response containing Pokemon details.
     */
    public Response getPokemonDetails(String pokemonName) {
        return sendGetRequest("pokemon/" + pokemonName);
    }

    /**
     * Retrieves the first ability of a Pokemon.
     * @param pokemonName Name of the Pokemon.
     * @return Name of the ability (if available).
     */
    public Optional<String> getFirstAbility(String pokemonName) {
        Response response = getPokemonDetails(pokemonName);
        List<String> abilities = response.jsonPath().getList("abilities.ability.name");
        return abilities.isEmpty() ? Optional.empty() : Optional.of(abilities.get(0));
    }

    /**
     * Retrieves details of a specific ability.
     * @param abilityName Name of the ability.
     * @return Response containing ability details.
     */
    public Response getAbilityDetails(String abilityName) {
        return sendGetRequest("ability/" + abilityName);
    }

    /**
     * Retrieves a list of Pokemon that have a specific ability.
     * @param abilityName Name of the ability.
     * @return List of Pokémon that possess this ability.
     */
    public List<String> getPokemonWithAbility(String abilityName) {
        Response response = getAbilityDetails(abilityName);
        return response.jsonPath().getList("pokemon.pokemon.name");
    }

    /**
     * Retrieves the types of a specific Pokemon.
     * @param pokemonName Name of the Pokemon.
     * @return List of the Pokemons types.
     */
    public List<String> getPokemonTypes(String pokemonName) {
        Response response = getPokemonDetails(pokemonName);
        return response.jsonPath().getList("types.type.name");
    }
}