package shesijie.bawei.com.ssj041202.presenter;

import shesijie.bawei.com.ssj041202.view.IView;

public interface IPresenter {
    void getModel();
    void attch(IView view);
    void detch();
}
