package cnwir.com.baseprj;

import android.app.Application;
import android.content.Context;

/**
 * Created by heaven on 2015/5/15.
 */
public class App extends Application{

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext(){

        return sContext;
    }
}
