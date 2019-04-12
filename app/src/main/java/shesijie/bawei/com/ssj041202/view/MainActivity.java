package shesijie.bawei.com.ssj041202.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import shesijie.bawei.com.ssj041202.R;
import shesijie.bawei.com.ssj041202.adapter.HomeAdapter;
import shesijie.bawei.com.ssj041202.bean.HomeBean;
import shesijie.bawei.com.ssj041202.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IView{

    Presenter presenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        init();
        presenter = new Presenter ();
        presenter.attch ( this );

    }

    private void init() {
        listView = findViewById ( R.id.main_list );
    }

    @Override
    public void getPresenter(String name) {
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(name, HomeBean.class);
        List<HomeBean.ResultBean> result = homeBean.getResult ();
        listView.setAdapter(new HomeAdapter ( this,result ) );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        presenter.detch ();
    }
}
