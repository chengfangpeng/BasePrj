package cnwir.com.baseprj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import cnwir.com.baseprj.R;
import cnwir.com.baseprj.domain.Img;

/**
 * Created by cfp on 15-9-24.
 */
public class ImgLoadRecycleAdapter extends RecyclerView.Adapter<ImgLoadRecycleAdapter.ViewHolder>{


    private Context context;

    private List<Img> datas;
    public ImgLoadRecycleAdapter(Context context, List<Img> datas){

        this.context = context;
        this.datas = datas;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.img_load_item, null);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(datas.get(position).getUrl(), viewHolder.img);


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_load_item);

        }
    }
}
