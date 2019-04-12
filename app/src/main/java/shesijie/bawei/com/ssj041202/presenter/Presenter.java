package shesijie.bawei.com.ssj041202.presenter;

import shesijie.bawei.com.ssj041202.model.IModel;
import shesijie.bawei.com.ssj041202.model.Model;
import shesijie.bawei.com.ssj041202.view.IView;

public class Presenter implements IPresenter {
    private IView view;
    Model model;

    @Override
    public void getModel() {

    }

    @Override
    public void attch(final IView view) {
        model = new Model ();
        this.view=view;
        model.login ( new IModel.CallBack () {
            @Override
            public void Success(String name) {
                view.getPresenter ( name );
            }

            @Override
            public void onFail() {

            }
        } );

    }

    @Override
    public void detch() {
        if (view!=null){
            view=null;
        }
        if (model!=null){
            model=null;
        }
        //防止内存溢出
        System.gc();
    }
}
