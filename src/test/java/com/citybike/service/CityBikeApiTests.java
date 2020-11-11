package com.citybike.service;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CityBikeApiTests {

    private final String host = "http://api.citybik.es/v2/networks";

    @Test
    public void testNetworks() {

        given().get(host)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }

    @Test
    public void testLatLong() {

        given().get(host + "/velobike-moscow")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200).and().body("network.location.latitude", notNullValue())
                .body("network.location.longitude", notNullValue());
    }

}
