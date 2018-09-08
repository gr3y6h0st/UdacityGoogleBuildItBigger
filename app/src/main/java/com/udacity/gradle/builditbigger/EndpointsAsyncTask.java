package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nanodegree.android.javajokeslibrary.TheJoker;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import static com.nanodegree.android.javajokeslibrary.TheJoker.THE_JOKE;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointsAsyncTask (Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.displayJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            String emptyStringReturn = "";
            return emptyStringReturn;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String formattedJoke = "GCE JOKE PULL: " + result;
        Toast.makeText(mContext, formattedJoke, Toast.LENGTH_LONG).show();

        //creates androidLibrary Activity intent.
        Intent androidLibJokesIntent = new Intent(mContext, TheJoker.class);
        //place joke result as a String Extra.
        androidLibJokesIntent.putExtra(THE_JOKE, result);

        //launch Android Library Activity
        mContext.startActivity(androidLibJokesIntent);

    }
}
