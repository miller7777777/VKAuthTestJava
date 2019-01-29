package ru.webim.vkauthtestjava;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

class InternetConnector {
    private Context context;
    private String request;
    private String content;

    public InternetConnector(Context context) {
        this.context = context;
    }

    public String getToken(){
        request = new StringBuilder()
                .append("https://oauth.vk.com/authorize?client_id=")
                .append("6830041")
                .append("&redirect_uri=")
                .append("https://oauth.vk.com/blank.html")
                .append("/callback&scope=12")
                .append("&display=mobile")
                .append("&response_type=token")
                .toString();

        DataLoader dataLoader = new DataLoader();
        dataLoader.execute(request);
        try {
            content = dataLoader.get();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return content;
    }

    //Осуществляет загрузку данных с сайта
    private class DataLoader extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String content;
            try {
                content = getContent(strings[0]);
            } catch (IOException ex) {
                content = ex.getMessage();
            }

            Log.d("Req777", "DataLoader: content = " + content);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader = null;
            try {
                URL url = new URL(path);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setRequestProperty("Accept-Charset", "UTF-8");
                c.setReadTimeout(10000);
                c.connect();

                reader = new BufferedReader(new InputStreamReader(c.getInputStream(), "windows-1251"));
                StringBuilder buf = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    buf.append(line + "\n");
                }

                String answer = buf.toString();

                return (answer);
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }

    }
}
