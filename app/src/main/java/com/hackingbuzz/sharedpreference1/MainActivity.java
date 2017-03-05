package com.hackingbuzz.sharedpreference1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TO save data in shared preference

        preferences = this.getSharedPreferences("com.hackingbuzz.sharedpreference1", Context.MODE_PRIVATE);


        preferences.edit().putInt("phoneNumber", 1234).apply();                 //2nd Run..once saved clear longs n comment that line that saves data..you will still find your data there
        preferences.edit().putString("username", "indiagate").apply();


    }

    public void getData(View view) {

        // now time to get data from shared preference..

        int phoneNumber = preferences.getInt("phoneNumber", -1);  // -1 return if preference does not exist
        String username = preferences.getString("username", "");  // return empty if preference does not exist.

        Log.i("GetData", phoneNumber+ "");
        Log.i("GetData", username);

        Toast.makeText(this, phoneNumber + " - " + username, Toast.LENGTH_SHORT).show();
    }
}


//To save data permanently we use saved preference...we use it mainly to store variable size data ..ex string, int , boolean etc..that  you put in forms..n similar type
//  data like...username,password, phone number, male, address, setlect one language..

//how to save in shared preference 1. get it 2.  edit it to save data..n appy
