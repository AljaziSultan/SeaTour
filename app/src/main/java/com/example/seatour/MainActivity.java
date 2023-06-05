package com.example.seatour;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;
    //ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
   // Button fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //////////////////////////////////////////////////////////
        //fab = findViewById(R.id.fab);
        bottomNavigationView=findViewById(R.id.BottomNavigationView);
        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView Nav_view = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        /////////////////////////////////////////////////////////
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
            Nav_view.setCheckedItem(R.id.Homeitem);
        }
       Nav_view.setNavigationItemSelectedListener(this);

        replaceFragement(new HomeFragment());

       bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.faby:
//                    Intent Date=new Intent(getBaseContext(), DatePickers.class);
//                    startActivity(Date);
                    break;
//                case R.id.Searchitem:
//                    Intent Date=new Intent(getBaseContext(), DatePickers.class);
//                    startActivity(Date);
//                    break;
                case R.id.Proitem:
                    Intent Date=new Intent(getBaseContext(), DatePickers.class);
                    startActivity(Date);
                    break;

                case R.id.Cart_item:
                    replaceFragement(new CalendarActivity());
                    break;

                case R.id.Chatitem:
                    replaceFragement(new MessagesFragment());
                    break;
                default:
                    break;

            }

           return true;
            });
            /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
       });

             */


    }

@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case
                    R.id.Homeitem:
                replaceFragement(new HomeFragment());
            break;
            case
                    R.id.Catitem:
                replaceFragement(new CategoriesFragment());
            break;
            case
                    R.id.BookMapitem:
                replaceFragement(new BookFragment());
                break;
            case
                    R.id.QuicKSearchitem:
                replaceFragement(new SearchFragment());

                break;
            case
                    R.id.AboutUsitem:
                replaceFragement(new AboutFragment());
                break;
            case
                    R.id.ContactUsitem:
                replaceFragement(new ContactFragment());
                break;
            case
                    R.id.LogOutitem:
                Toast.makeText(this,"Logout!", Toast.LENGTH_LONG).show();
                replaceFragement(new LogOutFragment());
                break;

            case
                    R.id.Profileitem:
                replaceFragement(new ProfileFragment());
                break;

            case
                    R.id.Calendaritem:
                replaceFragement(new CartFragment());
                break;
            default:
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);

        else
            super.onBackPressed();

    }
       /*
              if(){try{

            } catch( RuntimeException){}
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BottomNavigationView.setBackground(null);
   binding.BottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.fab:
                    replaceFragement(new HomeFragment());
                    break;
                case R.id.Searchitem:
                    replaceFragement(new SearchFragment());
                    break;
                case R.id.Proitem:
                    replaceFragement(new ProfileFragment());
                    break;

                case R.id.Cart_item:
                    replaceFragement(new CartFragment());
                    break;

                case R.id.Chatitem:
                    replaceFragement(new MessagesFragment());
                    break;
                default:
                    break;

            }


            return true;
        });*/



    //Outside Oncreate

           /* private void showBottomDialog() {

            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.bottomsheetlayout);

            LinearLayout upload = dialog.findViewById(R.id.Upload);
           // LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
           // LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
            ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                    Toast.makeText(MainActivity.this,"Upload an image or a video",Toast.LENGTH_SHORT).show();

                }
            });


            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);

        }

            */
    private void replaceFragement(Fragment fragement)
    {
        FragmentManager fragementmanager = getSupportFragmentManager();
        FragmentTransaction fragementTransction = fragementmanager.beginTransaction();
        fragementTransction.replace(R.id.frame_layout, fragement);
        fragementTransction.commit();

    }



}