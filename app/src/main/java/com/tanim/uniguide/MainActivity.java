package com.tanim.uniguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    TextView toTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Toast.makeText(MainActivity.this, "Introduction Section", Toast.LENGTH_SHORT).show();

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