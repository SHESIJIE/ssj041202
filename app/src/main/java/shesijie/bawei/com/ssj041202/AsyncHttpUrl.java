package shesijie.bawei.com.ssj041202;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncHttpUrl {
    private static AsyncHttpUrl httpUrl = new AsyncHttpUrl ();
    public static AsyncHttpUrl getHttpUrl(){
        return  httpUrl;
    }
    public void GetAsync(String server_url, final AsyncCallback callback){
        new AsyncTask<String, Void, String> () {
            @Override
            protected String doInBackground(String... strings) {
                return getDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty ( s )) {
                    callback.Success ( s );
                } else {
                    callback.Error ( 503,"未请求到数据" );
                }
            }
        }.execute ( server_url );
    }

    private String getDataHttp(String server_url) {
        try {
            URL url1 = new URL ( server_url );
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection ();
            connection.setReadTimeout ( 5000 );
            connection.setConnectTimeout ( 5000 );
            connection.setRequestMethod ( "GET" );
            if (connection.getResponseCode () == 200) {
                InputStream inputStream = connection.getInputStream ();
                String s = new String(ByteStreams.toByteArray(inputStream));
                return s;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return null;
    }

    public interface AsyncCallback{
        void Error(int errorcode,String message);
        void Success(String result);
    }
}
