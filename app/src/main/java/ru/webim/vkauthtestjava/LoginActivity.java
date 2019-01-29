package ru.webim.vkauthtestjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        InternetConnector connector = new InternetConnector(this);  //Объект, устанавливающий соединение с сайтом VK и получающий данные
//
//        String token = connector.getToken();
//        Log.d("Req777", "LoginActivity: token = " + token);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://oauth.vk.com/authorize?client_id=6830041&redirect_uri=https://oauth.vk.com/blank.html&scope=2&display=mobile&response_type=token");
        String response ="";
        Log.d("VKAuth", response);

    }
}
