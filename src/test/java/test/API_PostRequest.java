package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_PostRequest {
    @Test
    public void post01() {

        /*
         https://jsonplaceholder.typicode.com/posts URL’ine
aşağıdaki body ile bir POST request gönderdiğimizde

{
   "title": "API",
   "body": "API öğrenmek ne güzel",
   "userId": 10
}

dönen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body’sinin id hariç,

{
   "title": "API",
   "body": "API öğrenmek ne güzel",
   "userId": 10
}
         */

        //1. Request URL ve Body olutur
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject regBody = new JSONObject();

        regBody.put("title", "API");
        regBody.put("body", "API ogrenmek ne guzel");
        regBody.put("userId", 10);

        //2. Expected Data Oluştur
        JSONObject expBody = new JSONObject();

        expBody.put("title", "API");
        expBody.put("body", "API ogrenmek ne guzel");
        expBody.put("userId", 10);

        //Response Kaydet
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(regBody.toString())
                .post(url);
        JsonPath actBody = response.jsonPath();


        //Assertionlar
        response.then().assertThat().contentType(ContentType.JSON).statusCode(201);
        Assert.assertEquals(expBody.get("title"), actBody.get("title"));
        Assert.assertEquals(expBody.get("body"), actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"), actBody.get("userId"));



    }
}
