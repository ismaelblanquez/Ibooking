package com.ismael.ibooking.fragments;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import com.google.android.material.navigation.NavigationView;
import com.ismael.ibooking.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavController navController;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar la toolbar como ActionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Asignar el NavigationView
        //navigationView = findViewById(R.id.navigation_view);
        //navigationView.setNavigationItemSelectedListener(this);

        // Asignar el DrawerLayout y configurar el ActionBarDrawerToggle
       /* drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*/

        // Configurar el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // Configurar el NavigationUI para el botón de retroceso
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp();
    }

    // Configurar el NavigationView para cerrar el DrawerLayout al hacer clic en un elemento
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        drawerLayout.closeDrawers();

        switch (item.getItemId()) {
            case R.id.nav_home:
                navController.navigate(R.id.action_global_homeFragment);
                break;
            case R.id.nav_hotel:
                navController.navigate(R.id.action_global_hotelListFragment);
                break;
            case R.id.nav_reservation:
                navController.navigate(R.id.action_global_reservationFragment);
                break;
            case R.id.nav_history:
                navController.navigate(R.id.action_global_historyFragment);
                break;
            case R.id.nav_settings:
                navController.navigate(R.id.action_global_settingsFragment);
                break;
        }

        return true;
    }
}
