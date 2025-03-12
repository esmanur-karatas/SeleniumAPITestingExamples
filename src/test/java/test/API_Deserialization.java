package test;

import baseURLDeposu.JsonPlaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDataDeposu.JsonPlaceholderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_Deserialization extends JsonPlaceholderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine aşağıdaki
    body’e sahip bir PUT request yolladığınızda dönen response’in
    response body’sinin aşağıda verilen ile aynı olduğunu test ediniz

    Request Body:
    {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
    }

    Expected Data:
    {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
    }
     */

    @Test
    public void test01() {
        // Url belirle
        specJsonPlace.pathParam("pp1", 70);

        // Request body oluştur
        JsonPlaceholderTestData jsonPlaceholderTestData = new JsonPlaceholderTestData();
        Map<String, Object> reqBodyMap = jsonPlaceholderTestData.requestBodyMapCreate();

        // Expected data oluştur
        Map<String, Object> expDataMap = jsonPlaceholderTestData.requestBodyMapCreate();

        // Request gönder ve response kaydet
        Response response = given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .body(reqBodyMap)
                .when()
                .put("/{pp1}");

        // Assertion işlemi
        assertEquals(jsonPlaceholderTestData.successStatusCode, response.getStatusCode());
        Map<String, Object> resBodyMap = response.as(Map.class);  // Deserialization

        assertEquals(expDataMap.get("title"), resBodyMap.get("title"));
        assertEquals(expDataMap.get("body"), resBodyMap.get("body"));
        assertEquals(expDataMap.get("userId"), resBodyMap.get("userId"));
        assertEquals(expDataMap.get("id"), resBodyMap.get("id"));
    }
}
