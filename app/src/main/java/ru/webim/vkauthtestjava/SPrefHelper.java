package ru.webim.vkauthtestjava;

import android.content.Context;
import android.content.SharedPreferences;

class SPrefHelper {
    private SharedPreferences sPref;
    private Context context;
    private String token;

    public SPrefHelper(Context context){
        this.context = context;
        sPref = context.getSharedPreferences("settings.xml", Context.MODE_PRIVATE)
; }

    public String getToken() {

        token = sPref.getString("token", null);
        return token;
    }

    public void saveToken(String token){
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("token", token);
        editor.apply();
    }
}
