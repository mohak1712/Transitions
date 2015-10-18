package com.example.mohak.transitions;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(this, getdata());
        recyclerView.setAdapter(adapter);
        RelativeLayout vi = (RelativeLayout) findViewById(R.id.rel);
        Snackbar.make(vi, "Activity 1", Snackbar.LENGTH_INDEFINITE).show();

    }

    public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        Context context;
        ArrayList<single> Single;
        int mPosition;

        public Adapter(Context context, ArrayList<single> Single) {
            this.context = context;
            this.Single = Single;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final View v = inflater.inflate(R.layout.single, parent, false);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView view1 = (ImageView) view.findViewById(R.id.imageView);
                    if (Build.VERSION.SDK_INT >= 21) {
                        ActivityOptionsCompat a = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, view1, "abc");
                        startActivity(new Intent(MainActivity.this, Main2Activity.class), a.toBundle());

                    } else {
                        startActivity(new Intent(MainActivity.this, Main2Activity.class));
                    }
                }
            });
            MyViewHolder holder = new MyViewHolder(v);
            return holder;

        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            single s = Single.get(position);
            holder.textView.setText(s.Item);
            holder.imageView.setImageResource(s.Id);
            mPosition = position;

        }

        @Override
        public int getItemCount() {
            return Single.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
                textView = (TextView) itemView.findViewById(R.id.Mytext);
            }



            }
        }


//   Activity A's exit transition determines how views in A are animated when A starts B.

//   Activity B's enter transition determines how views in B are animated when A starts B.

//   Activity B's return transition determines how views in B are animated when B returns to A.

//   Activity A's reenter transition determines how views in A are animated when B returns to A.


    public ArrayList<single> getdata() {
        ArrayList<single> s = new ArrayList<>();
        String[] arr = {"s", "y", "a", "g"};
        int[] id = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        for (int i = 0; i < arr.length; i++) {
            single single = new single();
            single.Id = id[i];
            single.Item = arr[i];
            s.add(single);
        }
        return s;
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


}
