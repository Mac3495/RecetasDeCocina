package com.example.marcelo.recetasdecocina;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.ViewAnimationUtils;

public class SplashScreenActivity extends Activity {

    View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        myView = findViewById(R.id.reveal);

        Thread timerTread = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    //revealView();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                    startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(SplashScreenActivity.this).toBundle());
                }
            }
        };
        timerTread.start();
    }


    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

    public void revealView(){

        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

        anim.setDuration(1500);

        myView.setVisibility(View.VISIBLE);

        anim.start();
    }

}
