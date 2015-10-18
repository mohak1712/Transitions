package com.example.mohak.transitions;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeScroll;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class Main4Activity extends AppCompatActivity {


    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fab = (FloatingActionButton) findViewById(R.id.fab22);
        RelativeLayout vi = (RelativeLayout) findViewById(R.id.rl);
        Snackbar.make(vi, "Activity 4", Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onBackPressed() {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(Main4Activity.this, fab, "finally");
        startActivity(new Intent(Main4Activity.this, Main2Activity.class), options.toBundle());
    }

    //   Activity A's exit transition determines how views in A are animated when A starts B.

//   Activity B's enter transition determines how views in B are animated when A starts B.

//   Activity B's return transition determines how views in B are animated when B returns to A.

//   Activity A's reenter transition determines how views in A are animated when B returns to A.


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main4, menu);
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
}
