package cnwir.com.baseprj;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cnwir.com.baseprj.ui.BaseActivity;


public class MainActivity extends BaseActivity {
    @InjectView(R.id.textView)
    TextView tv;
    @InjectView(R.id.button)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        tv.setText("i am a test");
        btn.setText("you are sb");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv.setText("you are big sb!");

            }
        });

    }

}
