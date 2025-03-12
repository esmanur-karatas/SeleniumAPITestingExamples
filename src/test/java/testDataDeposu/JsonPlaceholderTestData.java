package testDataDeposu;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceholderTestData {

    public int successStatusCode = 200;

    public JSONObject expectedDataCreate() {
        JSONObject body = new JSONObject();
        body.put("userId", 3);
        body.put("id", 22);
        body.put("title", "dolor sint quo a velit explicabo quia nam");
        body.put("body", "eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");
        return body;
    }

    public Map requestBodyMapCreate(){
        Map <String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10.0);
        requestBodyMap.put("id",70.0);
        return requestBodyMap;
    }
}
