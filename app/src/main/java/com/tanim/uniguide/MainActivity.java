package com.tanim.uniguide;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    TextView toTxt;
    private DrawerLayout drawerLayout;
    private ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        menuIcon = findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the left side drawer
                drawerLayout.openDrawer(findViewById(R.id.navigationView));
            }
        });


        bottomNavigation  = findViewById(R.id.bottomNavigation);
        toTxt = findViewById(R.id.toolText);

        FragmentManager fgMan = getSupportFragmentManager();
        FragmentTransaction tran = fgMan.beginTransaction();

        Home nFg = new Home();
        tran.replace(R.id.Midcontainer,nFg);
        tran.commit();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nv_home) {

                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    Home nFg = new Home();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("CCE Pedia");

                } else if (item.getItemId() == R.id.nv_faculty) {
                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    faculty nFg = new faculty();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Faculties");

                } else if (item.getItemId() == R.id.nv_resource) {
                    Toast.makeText(MainActivity.this, "Resources Section", Toast.LENGTH_SHORT).show();

                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    resource nFg = new resource();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Resources");

                } else if (item.getItemId() == R.id.nv_author) {
                    Toast.makeText(MainActivity.this, "Author Section", Toast.LENGTH_SHORT).show();

                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    author nFg = new author();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Author");
                }

                return true;
            }
        });


    }
}