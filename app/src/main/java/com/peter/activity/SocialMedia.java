package com.peter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.peter.R;

public class SocialMedia extends AppCompatActivity {
TextView whatsApp, fb, youTube, telegram, instagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
    }
}
