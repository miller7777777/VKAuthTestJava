package ru.webim.vkauthtestjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InternetConnector connector = new InternetConnector();  //Объект, устанавливающий соединение с сайтом VK и получающий данные

    }
}
