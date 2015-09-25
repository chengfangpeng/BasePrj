package cnwir.com.baseprj.ui.imgload;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cnwir.com.baseprj.R;
import cnwir.com.baseprj.adapter.ImgLoadRecycleAdapter;
import cnwir.com.baseprj.data.ImgData;
import cnwir.com.baseprj.domain.Img;
import cnwir.com.baseprj.ui.BaseActivity;

public class ImgLoaderActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;

    private List<Img> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_loader);
        initData();
        initView();

    }

    private void initData() {
        datas = new ArrayList<Img>();
        for (int i = 0; i < ImgData.imgs.length; i++) {
            Img img = new Img();
            img.setUrl(ImgData.imgs[i]);
            datas.add(img);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.img_load_recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ImgLoadRecycleAdapter(this, datas);
        recyclerView.setAdapter(mAdapter);
    }


}
