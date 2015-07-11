package com.example.xfactor.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;

//contains app intro that shows only whem the user uses the app for the very first time

public class MainActivity extends AppIntro implements Frag3.OnFragmentInteractionListener {

     @Override
    public void init(Bundle savedInstanceState) {
    //Shared pref is used so that the intro is shown only the 1st time user installs the app
        SharedPreferences sharedPreferences = getSharedPreferences("PREF", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("my", true)) {

        // Dont forget to add VIBRATE permission in the manifest file
            addSlide(Frag1.newInstance("", ""), getApplicationContext());
            addSlide(Frag2.newInstance("", ""), getApplicationContext());
            addSlide(Frag3.newInstance("", ""), getApplicationContext());
            // OPTIONAL METHODS
            // Override bar/separator color
            setBarColor(Color.parseColor("#3F51B5"));
            setSeparatorColor(Color.parseColor("#2196F3"));

            // Hide Skip button
           showSkipButton(true);

            // Turn vibration on and set intensity
            // NOTE: you will probably need to ask VIBRATE permesssion in Manifest
            setVibrate(true);
            setVibrateIntensity(30);
            setFadeAnimation();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("my",false);
            editor.apply();
        }else
        {
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
            finish();

        }

    }

    @Override
    public void onSkipPressed() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
