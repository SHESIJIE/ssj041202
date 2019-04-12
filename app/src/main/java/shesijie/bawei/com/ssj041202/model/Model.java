package shesijie.bawei.com.ssj041202.model;

import shesijie.bawei.com.ssj041202.AsyncHttpUrl;

public class Model implements IModel {
    public static final String BaseUrl="http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";

    @Override
    public void login(final CallBack callBack) {
        AsyncHttpUrl.getHttpUrl ().GetAsync ( BaseUrl , new AsyncHttpUrl.AsyncCallback () {
            @Override
            public void Error(int errorcode , String message) {

            }

            @Override
            public void Success(String result) {
                callBack.Success ( result );
            }
        } );
    }
}
