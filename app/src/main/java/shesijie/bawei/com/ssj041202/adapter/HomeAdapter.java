package shesijie.bawei.com.ssj041202.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

import shesijie.bawei.com.ssj041202.R;
import shesijie.bawei.com.ssj041202.bean.HomeBean;


public class HomeAdapter extends BaseAdapter {

    Context context;
    private List<HomeBean.ResultBean> homeBeanResult;
    private ViewHodels viewHodels;
    private View inflate;

    public HomeAdapter(Context context, List<HomeBean.ResultBean> homeBean) {
        this.context=context;
        this.homeBeanResult=homeBean;


    }

    @Override
    public int getCount() {
        return homeBeanResult.size();
    }

    @Override
    public Object getItem(int position) {
        return homeBeanResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHodels viewHodels = null;
            if(convertView==null){
                viewHodels= new ViewHodels();
                convertView = View.inflate ( context,R.layout.item_list,null );
                viewHodels.imageView = convertView.findViewById ( R.id.list_iam );
                viewHodels.textView = convertView.findViewById ( R.id.list_name );
               convertView.setTag(viewHodels);
            }else {
                viewHodels= (ViewHodels) convertView.getTag();
            }

        viewHodels.textView.setText(homeBeanResult.get(position).getName());
        Glide.with(context).load(homeBeanResult.get(position).getLogo()).into(viewHodels.imageView);
        return convertView;
    }

    class  ViewHodels{
        TextView  textView;
        ImageView imageView;


    }



}
