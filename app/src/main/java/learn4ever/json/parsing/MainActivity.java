package learn4ever.json.parsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // defining variables
    private Button parseJsonData;
    private TextView jsonResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding id from XML
        jsonResultTextView = findViewById(R.id.json_result);

        parseJsonData = findViewById(R.id.button_parse_data);
        parseJsonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJsonData();
            }
        });
    }
        private void parseJsonData() {
            // reading string value from string.xml
            String url = getString(R.string.server_url);
            // creating request queue from volley class
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG, "onResponse..... " + response.toString());
                            // google GSON library does parsing for us- ie form string json data to java class
                            JsonResponseData jsonResponseData = new Gson().fromJson(response.toString(), JsonResponseData.class);

                            jsonResultTextView.setText("Response: Date " + jsonResponseData.getDate() + " Time "
                                    + jsonResponseData.getTime() + " Milli Second " + jsonResponseData.getMilliseconds_since_epoch());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            Log.d(TAG, "onErrorResponse..... ", error);
                            jsonResultTextView.setText("Response:"+error.getMessage());

                        }
                    });

            requestQueue.add(jsonObjectRequest);
        }
}
