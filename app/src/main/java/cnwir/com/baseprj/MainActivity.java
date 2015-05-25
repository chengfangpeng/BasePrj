package cnwir.com.baseprj;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cnwir.com.baseprj.adapter.MainAdpater;
import cnwir.com.baseprj.domain.AppInfo;
import cnwir.com.baseprj.ui.BaseActivity;
import cnwir.com.baseprj.view.list.DropDownListView;


public class MainActivity extends BaseActivity {

            @InjectView(R.id.pull_listview)
     DropDownListView list;
    private List<AppInfo> apps;

    private MainAdpater adapter ;

    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        apps = new ArrayList<AppInfo>();
        for(int i = 0; i < 20; i++){

            AppInfo info = new AppInfo();

            info.setTitle("item  " + index);
            apps.add(info);
        }

        adapter = new MainAdpater(this, apps);
        list.setAdapter(adapter);
        list.setOnDropDownListener(new DropDownListView.OnDropDownListener() {
            @Override
            public void onDropDown() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                    list.onDropDownComplete();
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });
        list.setOnBottomListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 20; i++) {
                    AppInfo info = new AppInfo();

                    info.setTitle("item  " + index);
                    apps.add(info);
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                    list.onBottomComplete();
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });
    }


}
