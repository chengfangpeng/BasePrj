package cnwir.com.baseprj;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cnwir.com.baseprj.adapter.MainAdpater;
import cnwir.com.baseprj.domain.AppInfo;
import cnwir.com.baseprj.ui.BaseActivity;
import cnwir.com.baseprj.utils.DoubleClickExitHelper;
import cnwir.com.baseprj.view.list.DropDownListView;


public class MainActivity extends BaseActivity {

    private DoubleClickExitHelper exitApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        exitApp = new DoubleClickExitHelper(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){

            exitApp.doubleClickExit(keyCode, event);
        }

        return super.onKeyDown(keyCode, event);
    }
}
