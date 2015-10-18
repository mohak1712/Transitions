package com.example.mohak.transitions;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    ImageView imageView;
    ViewGroup v;
    TextView textView1,textView2;
    private RelativeLayout vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vi = (RelativeLayout) findViewById(R.id.rl3);
        Snackbar.make(vi, "Activity 3", Snackbar.LENGTH_INDEFINITE).show();
        imageView = (ImageView) findViewById(R.id.imageView3);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.activity3);
        vi.setAnimation(anim);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.text);
        textView2.setAnimation(anim2);
        textView1.setAnimation(anim2);
//        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.image);
//        imageView.setAnimation(anim2);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Main3Activity.this,Main2Activity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
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
