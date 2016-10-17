package com.inc.miki.voulezvous;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.about) {
            startActivity(new Intent(this,about.class));

        } else if (id == R.id.menu) {
            startActivity(new Intent(this,menu.class));


        } else if (id == R.id.drink) {

            startActivity(new Intent(this,drink.class));

        }
        else if (id == R.id.novo) {

            Toast.makeText(this, "Uskoro noviteti u ponudi, sacekajte iduce azuriranje", Toast.LENGTH_SHORT).show();

        }

        else if (id == R.id.pictures) {
            startActivity(new Intent(this,pictures.class));

        } else if (id == R.id.fb) {
            try {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/717992151638073"));
                startActivity(intent);

            } catch (Exception e) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/voulezvousprijedor")));

            }

        } else if (id == R.id.insta) {

            Uri uri = Uri.parse("http://instagram.com/_u/voulez_vous__pd");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/voulez_vous__pd")));
            }

        } else if (id == R.id.map) {

            String geoLocation = "geo:44.977743,16.708024,?q=Voulez Vous Prijedor";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(geoLocation));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else if (id == R.id.contact) {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:066132132"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        else if (id == R.id.cform) { startActivity(new Intent(this, cform.class));}
        else if (id == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            // String shareBody = "Zvanična android aplikacija Caffe&Lounge bara Voulez Vous iz Prijedora \n Google Play : link  \n Instagram profil : www.instagram.com/voulez_vous__pd \n Facebook profil : www.facebook.com/voulezvousprijedor \n Website : U izradi ";
            String m = "https://play.google.com/store/apps/details?id=com.inc.miki.voulezvous";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Voulez Vous");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,  m);
            startActivity(Intent.createChooser(sharingIntent, "Preporučujemo deljenje preko Facebook-a "));



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }}