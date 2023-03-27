package com.ismael.ibooking.lstHoteles.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.ismael.ibooking.R;
import com.ismael.ibooking.lstHoteles.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent screenChanger = new Intent(getBaseContext(),
                        RegisterActivity.class //FichaDescriptiva-LoginActivity
                );
                startActivity(screenChanger);
            }
        }, 2000);
    }



}