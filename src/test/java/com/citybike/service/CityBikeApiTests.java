package com.citybike.service;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CityBikeApiTests {

    final String host = "http://api.citybik.es/v2/networks";

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

        given().get(host + "/v2/networks/velobike-moscow")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

    }

}
