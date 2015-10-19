package com.example.mohak.transitions;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ImageView imageView;
    RecyclerView recyclerView;
    Animation animation;
    private Animation animation2;
    private Adapter2 adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.sharedelement));
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.sharedelementimg));
        }
        setContentView(R.layout.activity_main2);
        CoordinatorLayout vi = (CoordinatorLayout) findViewById(R.id.coordinate);
        Snackbar.make(vi, "Activity 2", Snackbar.LENGTH_INDEFINITE).show();
        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.mipmap.ic_launcher);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (Build.VERSION.SDK_INT >= 21) {
                    animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.fab);
                    imageView.startAnimation(animation);
                    animation2 = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.recycleranim);
                    recyclerView.startAnimation(animation2);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            view.setTransitionName("finally");
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(Main2Activity.this, view, view.getTransitionName());
                            startActivity(new Intent(Main2Activity.this, Main4Activity.class), options.toBundle());

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
        });


//   Activity A's exit transition determines how views in A are animated when A starts B.

//   Activity B's enter transition determines how views in B are animated when A starts B.

//   Activity B's return transition determines how views in B are animated when B returns to A.

//   Activity A's reenter transition determines how views in A are animated when B returns to A.

        recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter2 = new Adapter2(this, getdata2());
        recyclerView.setAdapter(adapter2);

    }


    public ArrayList<single> getdata2() {
        ArrayList<single> s = new ArrayList<>();
        String[] arr = {"m", "o", "h", "a", "k", "p", "u", "r", "i", "l", "o", "l"};
        int[] id = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
                , R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        for (int i = 0; i < arr.length; i++) {
            single single = new single();
            single.Id = id[i];
            single.Item = arr[i];
            s.add(single);
        }
        return s;
    }

    public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder> implements View.OnClickListener {
        Context context;
        ArrayList<single> Single;
        int mPosition = -1;

        public Adapter2(Context context, ArrayList<single> Single) {
            this.context = context;
            this.Single = Single;

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.single2, parent, false);
            v.findViewById(R.id.view2).setOnClickListener(this);
            MyViewHolder holder = new MyViewHolder(v);
            return holder;

        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            single s = Single.get(position);
            holder.textView.setText(s.Item);
            holder.imageView.setImageResource(s.Id);
            animate(holder.cardView, position);

        }

        private void animate(CardView cardView, int position) {
            if (position > mPosition) {
                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.animations);
                cardView.startAnimation(animation);
                animation.setDuration(1000);
                mPosition = position;
            }
        }

        @Override
        public int getItemCount() {
            return Single.size();
        }

        @Override
        public void onClick(View view) {


            startActivity(new Intent(Main2Activity.this, Main3Activity.class));
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;
            CardView cardView;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
                textView = (TextView) itemView.findViewById(R.id.Mytext);
                cardView = (CardView) itemView.findViewById(R.id.view2);
            }

        }


    }
}
