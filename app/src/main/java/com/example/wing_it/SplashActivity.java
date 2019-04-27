package com.example.wing_it;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.splash_gif);
      Glide.with(this)
                .load(R.drawable.transparentchickenglitter2)
                .placeholder(R.drawable.transparentchickenglitter2)
                .into(imageView);

    }
}
