package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class API_GetRequest {
    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine
    bir GET Requestyolladığımızda donen Response' un
    status code' unun 200,
    content type' ının JSON,
    response body' sinde bulunan userId değerinin 5,
    response body' sinde bulunan title' ın "optio dolor molestias sit" olduğuna emin olun
    */

    @Test
    public void get01() {
        // 1 - Request Url ve Body Oluştur
        String baseUrl = "https://jsonplaceholder.typicode.com/posts/44";

        // 2 - Expected Data Oluştur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("userId", 5);
        expectedBody.put("title", "optio dolor molestias sit");

        //System.out.println(expectedBody); bunu bir kere gördükten sonra silebilirsiniz çünkü api testlerine çok ağır yük bindiriyor

        // 3 - Response' u Kaydet
        Response response = given().when().get(baseUrl); //json formatındaki istediğimiz değerlerin hepsini getiriyor alttaki koda da konsola yazdırıyor
        //response.prettyPrint(); //json formatında konsolda görebilmemiz için

        // 4 - Assertion İşlemleri
        //status code 200 dönüyor mu onu kontrol etmek için

        response.
                then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

        JsonPath actualBody = response.jsonPath();

        Assert.assertEquals(expectedBody.get("userId"), actualBody.get("userId"));
        Assert.assertEquals(expectedBody.get("title"), actualBody.get("title"));

    }
}
