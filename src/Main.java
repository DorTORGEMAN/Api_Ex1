import netscape.javascript.JSObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().
                url("https//free.currencyconverterapi.com/api/v5/convert?q=USD_ILS&compact=y")
                .build();
        Response response=client.newCall(request).execute();
        String JsonData=response.body().string();

        JSONObject mainJsonObject=new JSONObject(JsonData);
        JSONObject resultsJson =mainJsonObject.getJSONObject("USD_ILS");
        double val= resultsJson.getDouble("val");
        System.out.println(val);

    }
}