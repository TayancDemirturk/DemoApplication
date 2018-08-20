package tayancdemirturk.demoapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView=(TextView)findViewById(R.id.textView);
    }
    public void getJSON(final View view){
        AsyncTask asyncTask= new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {


                OkHttpClient client = new OkHttpClient();

                Request request=new Request.Builder()
                        .url("https://service.selmanalpdundar.com/service.php?list")
                        .build();

                Response response=null;

                try{
                    response =client.newCall(request).execute();
                    return response.body().toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                textView.setText(o.toString());
            }
        }.execute();
    }
}
