package api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
    }

    @Feature("API Test")
    @Story("API-001: api test for get users functionality")
    @Description("to test new user is created and get info of created of user  when create user api is called")
    @Test(description = "to verify new user is created when create user api is called")
    public void get_all_users_data_using_GET_Api()
    {
        Response response=
        given()
        .when()
        .get(api_config.getProperty("base_url1"));

        response.then()
        .statusCode(200);

        System.out.println(response.body().asString());

    }
}






