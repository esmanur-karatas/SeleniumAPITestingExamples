package test;

import baseURLDeposu.JsonPlaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDataDeposu.JsonPlaceholderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class API_BaseUrl_TestData extends JsonPlaceholderBaseUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladığımızda dönen response’in status kodunun 200 ve
response body’sinin aşağıda verilen ile aynı olduğunu test ediniz

Response body :
{
"userId":3,
"id":22,
"title":"dolor sint quo a velit explicabo quia nam",
"body":"eos qui et ipsum ipsam suscipit aut
sed omnis non odio
expedita earum mollitia molestiae aut atque rem suscipit
nam impedit esse"
}
       */
    @Test
    public void get01() {
//url ve request body oluştur
        specJsonPlace.pathParams("pp1", 22);
//        Response response = given()
//                .spec(specJsonPlace)
//                .when()
//                .get("{pp1}");
//        response.prettyPrint();

        //Expected Data Oluştur
        JsonPlaceholderTestData jsonPlaceholderTestData = new JsonPlaceholderTestData();
        JSONObject expBody = jsonPlaceholderTestData.expectedDataCreate();
        //System.out.println(expBody);

        //Response kaydet
        Response response = given().spec(specJsonPlace).when().get("{pp1}");
//        response.prettyPrint();

        //Asssertion
        JsonPath respJsonPath = response.jsonPath();
        assertEquals(jsonPlaceholderTestData.successStatusCode, response.getStatusCode());
        assertEquals(expBody.getInt("userId"), respJsonPath.getInt("userId"));
        assertEquals(expBody.getInt("id"), respJsonPath.getInt("id"));
        assertEquals(expBody.getString("title"), respJsonPath.getString("title"));
        assertEquals(expBody.getString("body"), respJsonPath.getString("body"));


    }
}
