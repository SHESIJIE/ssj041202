package shesijie.bawei.com.ssj041202.model;

public interface IModel {
    void login(IModel.CallBack callBack);
    interface CallBack{
        void Success(String name);
        void onFail();
    }
}
