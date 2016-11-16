package com.emedinaa.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emedinaa.sharedpreferences.entity.User;
import com.emedinaa.sharedpreferences.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.sharedpreferences.storage.SharedPreferencesHelper;
import com.emedinaa.sharedpreferences.utils.GsonHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private  final String MY_SHARED_PREFERENCES = "com.emedinaa.sharedpreferences";

    private SharedPreferencesHelper sharedPreferencesHelper;

    private TextView tviOutput;
    private Button btnEmail, btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app();
    }

    private void app() {
        SharedPreferences sharedPreferences= getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        GsonHelper gsonHelper= new GsonHelper();
        sharedPreferencesHelper= new DefaultSharedPreferencesHelper(gsonHelper,sharedPreferences);
        ui();
        events();
    }

    private void events() {
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               preferencesGson();
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferencesEmail();
            }
        });
    }

    private void ui() {
        tviOutput= (TextView)(findViewById(R.id.tviOutput));
        btnEmail= (Button) (findViewById(R.id.btnEmail));
        btnUser= (Button)(findViewById(R.id.btnUser));
    }

    private void preferencesEmail() {
        sharedPreferencesHelper.saveEmail("emedinaa@gmail.com");
        String email=sharedPreferencesHelper.email();

        Log.v(TAG, "email "+email);
        tviOutput.setText("email "+email);
    }

    private void preferencesGson() {
        User user= new User();
        user.setId(100);
        user.setName("Eduardo Medina");
        user.setEmail("emedinaa@gmail.com");

        sharedPreferencesHelper.saveUser(user);
        User userSp= sharedPreferencesHelper.user();

        Log.v(TAG, "userSp "+userSp);
        tviOutput.setText("user  "+userSp);
    }
}
