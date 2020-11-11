package com.citybike.service;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CityBikeApiTests {

    final String host = "http://api.citybik.es/v2/networks";

    @Test
    public void testNetworks() {

        Response response = given().get(host)
                .andReturn();

        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());

    }

    @Test
    public void testLatLong() {

        Response response = given().get(host + "/v2/networks/velobike-moscow")
                .andReturn();

        response.then().log().all();

        Assert.assertEquals(200, response.getStatusCode());

    }


}
