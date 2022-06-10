package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.APIUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.APIUtils.api_config;

public class getdata {
    @BeforeClass
    public void startUp() throws IOException {
        APIUtils.readAPIConfigs();
      //  APIUtils.setBaseURL();
    }

    @Test(priority=1)
     public void getallusersinfo()
    {
        Response response=
        given()
        .when()
        .get(api_config.getProperty("base_url1"));

        response.then()
        .statusCode(200);

      //  response.body().asString();
        System.out.println(response.body().asString());

//        Response response = RestAssured.get("base_url1");
//        System.out.println(response.asString());
//        System.out.println(response.getBody().asString());
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getHeader("content-type"));
//        System.out.println(response.getTime());

        //int statuscode = response.getStatusCode();
      //  Assert.assertEquals(statuscode,200);
    }






}

//https://reqres.in/api/users?page=2




