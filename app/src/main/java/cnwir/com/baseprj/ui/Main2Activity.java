package cnwir.com.baseprj.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import cnwir.com.baseprj.R;

public class Main2Activity extends Activity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    private Object data;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getData();
    }

    public void getData() {

         requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest("http://www.qingting.org.cn/app/popularity", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.d(TAG, jsonObject.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(request);
        Log.d(TAG,"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        requestQueue.cancelAll(this);
    }
}
