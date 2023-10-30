package com.tanim.uniguide;

import static com.tanim.uniguide.LoginActivity.PREFS_NAME;
import static com.tanim.uniguide.LoginActivity.SEMESTER_KEY;
import static com.tanim.uniguide.LoginActivity.STUDENT_NAME_KEY;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    LinearLayout sideMenu;
    TextView toTxt;
    TextView stName;
    TextView stSem;
    String menuResLink = "https://cce.iiuc.ac.bd";
    private DrawerLayout drawerLayout;
    private ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        menuIcon = findViewById(R.id.menuIcon);
        sideMenu = findViewById(R.id.sideMenu);
        toTxt = findViewById(R.id.toolText);
        bottomNavigation  = findViewById(R.id.bottomNavigation);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String studentName = settings.getString(STUDENT_NAME_KEY, "Name");
        int semesterId = settings.getInt(SEMESTER_KEY, 1); // Default to Semester 1 if not found

        stName = findViewById(R.id.stuName);
        stSem = findViewById(R.id.stuSem);
        stName.setText("Name: " + studentName);
        stSem.setText("Semester: " + semesterId);

        Drawable originalDrawable = getResources().getDrawable(R.drawable.menu); // Your original image resource
        Drawable newDrawable = getResources().getDrawable(R.drawable.mn_close); // The new image you want to display
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sideMenu.getVisibility() == View.VISIBLE) {
                    sideMenu.setVisibility(View.INVISIBLE);
                    menuIcon.setImageDrawable(originalDrawable);
                } else {
                    sideMenu.setVisibility(View.VISIBLE);
                    menuIcon.setImageDrawable(newDrawable);
                }
            }
        });

        Button ediIn = findViewById(R.id.editInfo);
        ediIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

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
                    sideMenu.setVisibility(View.INVISIBLE);
                    menuIcon.setImageDrawable(originalDrawable);

                } else if (item.getItemId() == R.id.nv_faculty) {
                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    faculty nFg = new faculty();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Faculties");
                    sideMenu.setVisibility(View.INVISIBLE);
                    menuIcon.setImageDrawable(originalDrawable);

                } else if (item.getItemId() == R.id.nv_resource) {
                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    resources nFg = new resources();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Resources");
                    sideMenu.setVisibility(View.INVISIBLE);
                    menuIcon.setImageDrawable(originalDrawable);

                } else if (item.getItemId() == R.id.nv_author) {
                    Toast.makeText(MainActivity.this, "Author Section", Toast.LENGTH_SHORT).show();

                    FragmentManager fgMan = getSupportFragmentManager();
                    FragmentTransaction tran = fgMan.beginTransaction();

                    author nFg = new author();
                    tran.replace(R.id.Midcontainer,nFg);
                    tran.commit();
                    toTxt.setText("Author");
                    sideMenu.setVisibility(View.INVISIBLE);
                    menuIcon.setImageDrawable(originalDrawable);
                }
                return true;
            }
        });
        TextView menuSemRes = findViewById(R.id.menuSemRes);
        menuSemRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(menuResLink));
                startActivity(intent);
            }
        });

        switch (semesterId) {
            case 1 : menuSemRes.setText("1st Semester Resources");
            menuResLink = "https://jpst.it/3q4Ai";
                break;
            case 2 : menuSemRes.setText("2nd Semester Resources");
                menuResLink = "https://jpst.it/3q4Em";
                break;
            case 3 : menuSemRes.setText("3rd Semester Resources");
                menuResLink = "https://jpst.it/3q4I3";
                break;
            case 4 : menuSemRes.setText("4th Semester Resources");
                menuResLink = "https://jpst.it/3q4Jm";
                break;
            case 5 : menuSemRes.setText("5th Semester Resources");
                menuResLink = "https://jpst.it/3q6UJ";
                break;
            case 6 : menuSemRes.setText("6th Semester Resources");
                menuResLink = "https://jpst.it/3q6Wm";
                break;
            case 7 : menuSemRes.setText("7th Semester Resources");
                menuResLink = "https://jpst.it/3q6X0";
                break;
            case 8 : menuSemRes.setText("8th Semester Resources");
                menuResLink = "https://jpst.it/3q6XV";
                break;
        }
    }
}