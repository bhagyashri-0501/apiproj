package api;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.APIUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class postdata {

    @BeforeClass
    public void startUp() throws IOException {
        APIUtils.readAPIConfigs();
        APIUtils.setBaseURL2();
    }

    @Test(priority =2)
    public void test_user_created_successfully_using_post_api_method1_body_from_json_file() throws Exception {
        String end_point = APIUtils.api_config.getProperty("create_user_end_point");
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "/src/test/java/resources/api_test_data_create_userJSONBody.json"));

//        Map<String, Object> map = new HashMap<String, Object>();
  //      map.put("name", "Raghav");
    //    map.put("job", "Teacher");
    //    System.out.println(map);

//        JSONObject request = new JSONObject();
//        request.put("name", "shri");
//        request.put("job", "Teacher");
//        System.out.println(request.toString());

         String baseURI = "base_url2";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(body).
                when().
                post(baseURI+"/users").
                then().
                statusCode(201).log().all();

      //  int statuscode = response.getStatusCode();
      //  Assert.assertEquals(statuscode,201);
    }
}
