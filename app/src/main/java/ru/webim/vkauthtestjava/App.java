package ru.webim.vkauthtestjava;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SPrefHelper sPrefHelper = new SPrefHelper(getApplicationContext());    //Объеккт, работающий с SharedPreferens
        String token = sPrefHelper.getToken();          //Если токен сохранен, получаем токен


        if(token != null){
            //проверка: валидный ли токен
                //если да: запуск страницы с данными
            Intent userDataIntent = new Intent(this, UserDataActivity.class);
                //если нет: запуск страницы авторизации
            Intent loginIntent = new Intent(this, UserDataActivity.class);

        } else {
            //запуск страницы авторизации
            Intent loginIntent = new Intent(this, UserDataActivity.class);


        }

    }
}
