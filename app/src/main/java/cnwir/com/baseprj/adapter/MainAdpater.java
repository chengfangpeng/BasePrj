package cnwir.com.baseprj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cnwir.com.baseprj.MainActivity;
import cnwir.com.baseprj.R;
import cnwir.com.baseprj.domain.AppInfo;

/**
 * Created by Windows on 2015/5/22.
 */
public class MainAdpater extends BaseAdapter {

    private Context context;
    private List<AppInfo> apps;
    private LayoutInflater inflater;


    public MainAdpater(Context context, List<AppInfo> apps) {
        super();
        this.context = context;
        this.apps = apps;
        inflater = LayoutInflater.from(context);

    }




    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int position) {
        return apps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_item, null);
            holder.tilte = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.tilte.setText(apps.get(position).getTitle());
        return convertView;
    }

    private class ViewHolder {

        TextView tilte;

    }
}
