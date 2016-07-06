package com.why.mediasdp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mp3Activity extends AppCompatActivity {

    private TextView tvMp3Title, tvLeft,tvRight;
    private SeekBar seekbarMp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        setTitle("Play Mp3");

        tvMp3Title=(TextView)findViewById(R.id.tvMp3Title);
        tvLeft=(TextView)findViewById(R.id.tvLeft);
        tvRight=(TextView)findViewById(R.id.tvRight);
        seekbarMp3=(SeekBar)findViewById(R.id.seekBar);

        tvMp3Title.setText("tv Mp3");
        tvLeft.setText("tv Left");
        tvRight.setText("tv Right");
    }
}
