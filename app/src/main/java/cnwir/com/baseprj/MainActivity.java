package cnwir.com.baseprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cnwir.com.baseprj.domain.AppInfo;
import cnwir.com.baseprj.ui.BaseActivity;
import cnwir.com.baseprj.ui.Main2Activity;
import cnwir.com.baseprj.ui.imgload.ImgLoaderActivity;
import cnwir.com.baseprj.ui.sqlitedemo.SqliteDemoActivity;
import cnwir.com.baseprj.utils.DoubleClickExitHelper;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private DoubleClickExitHelper exitApp;
    @InjectView(R.id.img_loader_btn)
    Button imgLoaderBtn;
    @InjectView(R.id.use_sqlite)
    Button useSqlte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        exitApp = new DoubleClickExitHelper(this);
        imgLoaderBtn.setOnClickListener(this);
        useSqlte.setOnClickListener(this);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            exitApp.doubleClickExit(keyCode, event);
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_loader_btn:
                startActivity(new Intent(this, ImgLoaderActivity.class));
                break;
            case R.id.use_sqlite:

                startActivity(new Intent(this, SqliteDemoActivity.class));
                break;
        }

    }
}
