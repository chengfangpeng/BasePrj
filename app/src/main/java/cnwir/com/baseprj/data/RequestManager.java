package cnwir.com.baseprj.data;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import cnwir.com.baseprj.App;

/**
 * Created by heaven on 2015/5/15.
 */
public class RequestManager {

    public static RequestQueue mRequestQueue = Volley.newRequestQueue(App.getContext());

    private RequestManager() {
        // no instances
    }

    public static void addRequestQueue(Request<?> request, Object tag){

        if(tag != null){

            request.setTag(tag);
        }

        mRequestQueue.add(request);

    }
    public static void cancelAllRequest(Object object){

        mRequestQueue.cancelAll(object);


    }

}
