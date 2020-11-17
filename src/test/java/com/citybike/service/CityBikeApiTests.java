package com.citybike.service;

import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CityBikeApiTests {

    private final String host = "http://api.citybik.es/v2/networks";

    @Ignore
    @Test
    public void testNetworks() {

        given().get("http://api.citybik.es/v2/networks")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .log().all()
                .body("networks[0].location.city", notNullValue());

    }

    @Ignore
    @Test
    public void testLatLong() {

        given().get(host + "/velobike-moscow")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200).and().body("network.location.latitude", notNullValue())
                .body("network.location.longitude", notNullValue());
    }

    @Ignore
    @Test
    public void testCountry() {

        given().get(host + "/bycyklen")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testCity() {

        given().get(host + "/bycyklen")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200)
                .and()
                .body("network.location.city", notNullValue())
                .and()
                .body("network.location.country", equalTo("DK"))
                .and()
                .body("network.location.latitude", notNullValue())
                .and()
                .body("network.location.longitude", notNullValue());
    }

}

